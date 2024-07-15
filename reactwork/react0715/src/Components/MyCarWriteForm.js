import React from 'react';
import {Alert, Button} from "@mui/material";
import axios from "axios";

const MyCarWriteForm = ({addMycarEvent}) => {
    const photopath="https://kr.object.ncloudstorage.com/mycar/MyCarPhotos";
    const [carname, setCarname] = React.useState("");
    const [carprice, setCarprice] = React.useState("");
    const [carcolor, setCarcolor] = React.useState("#c0c0c0");
    const [carguip,setCarguip] = React.useState("2000-01-01");
    const [carphoto, setCarphoto] = React.useState("");

    //파일 업로드 이벤트
    const photoUploadEvent=(e)=>{
        const uploadFilename=e.target.files[0];
        const uploadForm=new FormData();
        uploadForm.append("upload",uploadFilename);
        axios({
            method:'post',
            url:'/mycar/upload',
            data:uploadForm,
            headers:{'Content-Type':'multipart/form-data'}
        }).then(res=>{
            setCarphoto(res.data.carphoto);
        })
    }
    //등록 이벤트
    const addDataEvent=()=>{
        addMycarEvent({carname,carprice,carguip,carphoto,carcolor});
        //입력값 초기화
        setCarcolor("#c0c0c0");
        setCarguip("2000-01-01");
        setCarprice("0");
        setCarname("");
        setCarphoto("");
    }
    return (
        <div>
            <Alert severity={'error'}>자동차 등록하기</Alert>
            <table className="table table-striped" style={{width:'500px'}}>
                <tbody>
                <tr>
                    <td className={'table-success'} style={{width: '100px'}}>자동차명</td>
                    <td style={{width:'200px'}}><input type={'text'} className={'form-control'}
                               style={{width: '200px'}} value={carname}
                               onChange={(e) => setCarname(e.target.value)}/></td>
                    <td rowSpan={5} valign={'middle'}>
                        <img src={`${photopath}/${carphoto}`} alt={carname} style={{maxWidth:'200px'}}/>
                    </td>
                </tr>
                <tr>
                    <td className={'table-success'} style={{width: '100px'}}>가격</td>
                    <td><input type={'text'} className={'form-control'}
                               style={{width: '200px'}} value={carprice}
                               onChange={(e) => setCarprice(e.target.value)}/></td>
                </tr>
                <tr>
                    <td className={'table-success'} style={{width: '100px'}}>색상</td>
                    <td><input type={'color'} className={'input-group'}
                               style={{width: '200px'}} value={carcolor}
                               onChange={(e) => setCarcolor(e.target.value)}/></td>
                </tr>
                <tr>
                    <td className={'table-success'} style={{width: '100px'}}>구입일</td>
                    <td><input type={'date'} className={'form-control'}
                               style={{width: '200px'}} value={carguip}
                               onChange={(e) => setCarguip(e.target.value)}/></td>
                </tr>
                <tr>
                    <td className={'table-success'} style={{width: '100px'}}>차량 사진</td>
                    <td><input type={'file'} className={'form-control'}
                    style={{width:'200px'}} onChange={photoUploadEvent}/></td>
                </tr>
                <tr>
                    <td colSpan={3} align={'center'}>
                        <Button variant={'outlined'} onClick={addDataEvent}>제출</Button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default MyCarWriteForm;
