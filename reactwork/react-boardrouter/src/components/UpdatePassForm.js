import React, {useEffect, useRef, useState} from 'react';
import {useNavigate, useParams} from "react-router-dom";
import {Alert, Button} from "@mui/material";
import {format} from "date-fns";
import axios from "axios";
import {Editor, Viewer} from "@toast-ui/react-editor";
import colorPlugin from "@toast-ui/editor-plugin-color-syntax";
import {CameraAltOutlined} from "@mui/icons-material";

const UpdatePassForm = () => {
    const storage = process.env.REACT_APP_STORAGE;
    const navi=useNavigate();
    const {boardNum}=useParams();
    const [dto,setDto]=useState({});
    const [loading, setLoading] = useState(true);
    const [title,setTitle]=useState('');
    const contentRef=useRef(null);
    const fileRef=useRef(null);
    const [photo,setPhoto]=useState('');

    const getData = () => {
        let url = "/boot/board/updateForm?boardNum=" + boardNum;
        axios.get(url).then(res => {
            setDto(res.data);
            setTitle(res.data.title);
            if (contentRef.current) {
                contentRef.current.getInstance().setMarkdown(res.data.content);
            }
            setPhoto(res.data.photo);
            setLoading(false);
        }).catch(error => {
            console.error("There was an error fetching the data!", error);
            setLoading(false);
        });
    };
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
    const sendUpdateData=()=>{
        const updatedContent = contentRef.current.getInstance().getHTML(); // 또는 getHTML()
        // 여기에 업데이트 요청을 보내는 코드를 추가합니다
        const formData=new FormData();
        formData.append('boardNum',boardNum);
        formData.append('title',title);
        formData.append('content',updatedContent);
        formData.append('photo',photo);

        let url=`/boot/board/update`;
        axios.post(url,formData).then(res=>{
            navi(`/board/detail/${boardNum}`);
        })
    }

    useEffect(() => {
        getData();
        }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!dto) {
        return <div>Error loading data</div>;
    }

    return (
        <div>
            <Alert severity={'info'}>수정 폼</Alert>
            <table className={'table table-borderless'} style={{width: '600px', marginLeft: '20px'}}>
                <tbody>
                <tr>
                    <th colSpan={2}>제목 <input type={'text'} name={'title'} style={{width:'400px'}}
                                                                       value={title} onChange={(e)=>setTitle(e.target.value)}
                    className={'form-control'}/> </th>
                </tr>
                <tr>
                    <td>작성자 : {dto.writer}</td>
                    <td align={'right'}>
                        작성일 : <span style={{
                        fontSize: '14px',
                        color: 'gray'
                    }}>{format(new Date(dto.writeday), "yyyy-MM-dd HH:mm")}</span>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{borderTop: '1px solid gray', borderBottom: '1px solid gray'}}>
                        <Editor
                            placeholder="내용을 입력해주세요."
                            previewStyle="vertical" // 미리보기 스타일 지정
                            height="500px" // 에디터 창 높이
                            initialEditType="wysiwyg" // 초기 입력모드 설정(디폴트 markdown)
                            plugins={[colorPlugin]}
                            initialValue={dto.content}
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
                                        callback(storage + "/" + res.data)//스토리지 파일명을 img태그에 넣어준
                                    })

                                    //callback(blob.name);//사진명만 일단 확인-사진 안나옴
                                }
                            }}
                            ref={contentRef}
                        ></Editor>
                        <CameraAltOutlined onClick={() => fileRef.current.click()}
                                           style={{cursor: 'pointer', fontSize: '30px', marginTop: '10px'}}/>
                        <input type={'file'} style={{display: 'none', width: '100%'}} className={'form-control'}
                               ref={fileRef} onChange={uploadPhoto}/>
                        {/*    스토리지에 저장된 이미지 출력*/}
                        <img alt={''} src={`${storage}/${photo}`} style={{width: '200px', marginLeft: '30px'}}/>
                    </td>
                </tr>
                <tr>
                    <td align={'right'} colSpan={2}>
                        <Button variant={'outlined'} color={'success'}
                                onClick={() => navi('/board/list')}>목록</Button>&emsp;
                        <Button variant={'outlined'} color={'info'} onClick={sendUpdateData}>
                            수정 완료
                        </Button>&emsp;
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default UpdatePassForm;
