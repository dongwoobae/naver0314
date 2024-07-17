import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";
import InputEmojiWithRef from "react-input-emoji";
import {CameraAltOutlined} from "@mui/icons-material";

const storage=process.env.REACT_APP_STORAGE;

const BoardForm = () => {
    const fileRef=useRef(null);
    const contentRef=useRef(null);
    const [writer,setWriter]=useState('');
    const [pass,setPass]=useState('');
    const [title,setTitle]=useState('');
    const [photo, setPhoto]=useState('no');

    //파일 업로드 이벤트
    const uploadPhoto=(e)=>{

    }
    //파일 저장 이벤트
    const dataSaveEvent=()=>{

    }
    return (
        <div>
            <Alert>게시판 글쓰기</Alert>
            <table className={'table table-bordered'} style={{width: '600px',margin:'10px'}}>
                <tbody>
                <tr>
                    <th className={'table-info'}>작성자</th>
                    <td><input type={'text'} className={'form-control'}/> </td>
                </tr>
                <tr>
                    <th className={'table-info'}>비밀번호</th>
                    <td><input type={'password'} className={'form-control'}/> </td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        <InputEmojiWithRef
                            placeholder={'제목'}
                            cleanOnEnter={true}
                            onEnter={(text)=>{
                                console.log(text)
                            }}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2}>
                        <input type={'file'} style={{display:'none',width:'100%'}} className={'form-control'} ref={fileRef}/>
                        <textarea style={{width:'100%'}} className={'form-control'} rows={10} placeholder={'내용'}></textarea>
                        <CameraAltOutlined onClick={()=>fileRef.current.click()} style={{cursor:'pointer',fontSize:'30px',marginTop:'10px'}}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{textAlign:'center'}}>
                        <Button variant={'contained'} color={'success'}>글쓰기 완료</Button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default BoardForm;
