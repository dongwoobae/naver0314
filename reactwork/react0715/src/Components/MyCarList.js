import React, {useEffect, useState} from 'react';
import axios from "axios";
import {Alert, Button} from "@mui/material";
import 'bootstrap/dist/css/bootstrap.min.css';
import MyCarRowItems from "./MyCarRowItems";
import MyCarWriteForm from "./MyCarWriteForm";

const MyCarList = () => {
    const [carList, setCarList] = useState([]);
    const [formShow, setFormShow] = useState(true);
    const mycarList=()=>{
        //설정에 proxy를 안넣으면 url 전체를 넣어줘야함
        axios.get("/mycar/list").then(res=>setCarList(res.data));
    }
    //처음 시작시 목록 가져오기 (처음 한번만 호출)
    useEffect(()=>{
        mycarList();
    },[]);
    //자동차 등록 이벤트
    const addMycarEvent=(data)=>{
        console.log(data);
        axios.post("/mycar/insert",data).then(res=>{
            mycarList();
        })
    }
    //삭제 이벤트
    const deleteMycarEvent=(num,photo)=>{
        let a = window.confirm("삭제?");
        if(a){
            axios.delete('/mycar/delete', {
                params: {
                    num: num,
                    photo: photo
                }
            }).then(res=>{
                mycarList();
            })
        }
    }
    //수정 버튼 이벤트
    const updateMycar=(data)=>{
        axios.post("/mycar/update",data).then(res=>{
            mycarList();
        })
    }
    return (
        <div>
            <Button variant={'contained'} color={'info'}
            onClick={()=>setFormShow(!formShow)}>자동차 등록 Show/Hide</Button>
            {
                formShow&&
                <MyCarWriteForm addMycarEvent={addMycarEvent}/>
            }
            <Alert severity={'success'}
            style={{fontSize:'15px',width:'500px'}}>
                <b>총 {carList.length} 개의 자동차 정보가 있습니다</b>
            </Alert>
            <table className="table table-bordered" style={{width:"500px"}} >
                <thead>
                <tr>
                    <th style={{width: '120px'}}>자동차명</th>
                    <th style={{width: '100px'}}>가격</th>
                    <th style={{width: '60px'}}>색상</th>
                    <th style={{width: '120px'}}>구입일</th>
                    <th style={{width: '120px'}}>등록일</th>
                </tr>
                </thead>
                <tbody>
                {
                    carList.map((row,idx)=>{
                        return <MyCarRowItems key={idx} row={row} idx={idx} onDelete={deleteMycarEvent}
                        onUpdate={updateMycar}/>
                    })
                }
                </tbody>
            </table>
        </div>
    );
};

export default MyCarList;
