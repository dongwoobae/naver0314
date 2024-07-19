import React, {useEffect, useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";
import {CameraAltOutlined} from "@mui/icons-material";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import '@toast-ui/editor/dist/toastui-editor.css';
import 'tui-color-picker/dist/tui-color-picker.css';
import '@toast-ui/editor-plugin-color-syntax/dist/toastui-editor-plugin-color-syntax.css';
import {Editor,Viewer} from "@toast-ui/react-editor";
import colorPlugin from "@toast-ui/editor-plugin-color-syntax";

//env 변수 받아오기
const storage=process.env.REACT_APP_STORAGE;


const BoardForm = () => {
    const navigate=useNavigate();
    const fileRef=useRef(null);
    const contentRef=useRef('');
    const [writer,setWriter]=useState('');
    const [pass,setPass]=useState('');
    const [title,setTitle]=useState('');
    const [photo, setPhoto]=useState('no');

    //파일 업로드 이벤트
    const uploadPhoto=(e)=>{
        const file=e.target.files[0];
        const uploadFormData=new FormData();
        uploadFormData.append("upload",file);
        axios({
            method:'post',
            url:'/boot/board/insertPhoto',
            data:uploadFormData,
            headers:{"Content-Type":"multipart/form-data"}
        }).then((res)=>{
            //스토리지에 저장된 파일명이 리턴
            setPhoto(res.data);
        });
    }
    useEffect(()=>{
        contentRef.current?.getInstance().setHTML('');
    },[]);
    let content='';
    //파일 저장 이벤트
    const dataSaveEvent=()=>{
        if(writer===''||writer===null){
            alert('작성자 입력 요망');
        }else if(pass===''||pass===null){
            alert('비밀번호 입력 요망');
        }else if(title===''||title===null){
            alert('제목 입력 요망');
        }else {
            axios.post("/boot/board/insert",{writer,pass,photo,title,content})
                .then(res=>{
                    //추가 성공 후 값 초기화 후 목록으로 이동
                    setPhoto('no');
                    setWriter('');
                    setTitle('');
                    setPass('');
                    content='';
                    navigate('/board/list');
                })
            contentRef.current?.getInstance().setHTML('');
        }
    }
    return (
        <div>
            <Alert>게시판 글쓰기</Alert>
            <table className={'table table-bordered'} style={{width: '400px',margin:'10px'}}>
                <tbody>
                <tr>
                    <th className={'table-info'}>작성자</th>
                    <td><input type={'text'} className={'form-control'} value={writer} onChange={(e)=>setWriter(e.target.value)}/> </td>
                </tr>
                <tr>
                    <th className={'table-info'}>비밀번호</th>
                    <td><input type={'password'} className={'form-control'} value={pass} onChange={(e)=>setPass(e.target.value)}/> </td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        <input type={'text'} className={'form-control'} value={title} onChange={(e)=>setTitle(e.target.value)}
                        placeholder={'제목 입력'}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{height:'fit-content'}}>
                        <input type={'file'} style={{display:'none',width:'100%'}} className={'form-control'} ref={fileRef} onChange={uploadPhoto}/>
                        <Editor
                            placeholder="내용을 입력해주세요."
                            previewStyle="vertical" // 미리보기 스타일 지정
                            height="500px" // 에디터 창 높이
                            initialEditType="wysiwyg" // 초기 입력모드 설정(디폴트 markdown)
                            plugins={[colorPlugin]}
                            toolbarItems={[
                                // 툴바 옵션 설정
                                ['heading', 'bold', 'italic', 'strike'],
                                ['hr', 'quote'],
                                ['ul', 'ol', 'task', 'indent', 'outdent'],
                                //['table', 'image', 'link'],
                                ['image'],
                                ['code', 'codeblock']
                            ]}

                            hooks={{
                                addImageBlobHook: async (blob, callback) => {
                                    console.log(blob);
                                    const formData = new FormData()
                                    formData.append('upload', blob)

                                    let url = "/boot/board/insertPhoto" //백엔드에서 스토리지에 사진 저장하기

                                    axios.post(url, formData, {
                                        header: {"content-type": "multipart/formdata"}
                                    }).then(res => {
                                        callback(storage+"/"+res.data)//스토리지 파일명을 img태그에 넣어준
                                    })

                                    //callback(blob.name);//사진명만 일단 확인-사진 안나옴
                                }
                            }}
                            ref={contentRef}
                        ></Editor>
                        <Viewer initialValue={content} />
                        <CameraAltOutlined onClick={()=>fileRef.current.click()} style={{cursor:'pointer',fontSize:'30px',marginTop:'10px'}}/>
                    {/*    스토리지에 저장된 이미지 출력*/}
                        <img alt={''} src={`${storage}/${photo}`} style={{width:'200px',marginLeft:'30px'}}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{textAlign:'center'}}>
                        <Button variant={'contained'} color={'success'} onClick={dataSaveEvent}>글쓰기 완료</Button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default BoardForm;
