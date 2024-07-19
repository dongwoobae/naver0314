import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import axios from "axios";
import {format} from "date-fns";
import {useNavigate} from "react-router-dom";
import './MyStyle.css';
import noimage from '../image/noimage.jpeg';

const BoardList = () => {
    const thumbnailFront=process.env.REACT_APP_THUMBNAIL;
    const thumbnailBack=process.env.REACT_APP_THUMBNAIL2;

    const navigate=useNavigate();
    const [list,setList]=useState([]);
    const callList=()=>{
        axios.get("/boot/board/list").then(res=>{
            setList(res.data);
        });
    }
    useEffect(()=>{
        callList();
    },[]);
    return (
        <div>
            <Alert>게시판 목록 - 총 {list.length} 개의 게시글이 있습니다</Alert>
            <table className={'table table-striped'} style={{width:'600px',marginLeft:'20px'}}>
                <thead>
                <tr>
                    <th style={{width:'50px'}}>번호</th>
                    <th style={{width:'250px'}}>제목</th>
                    <th style={{width:'100px'}}>작성자</th>
                    <th>조회수</th>
                    <th style={{width:'120px'}}>작성일</th>
                </tr>
                </thead>
                <tbody>
                {
                    list&&
                    list.map((item,idx)=>{
                        let photoSrc='';
                        if(item.photo==='no'){
                            photoSrc=noimage;
                        }else{
                            photoSrc=thumbnailFront+"/"+item.photo+thumbnailBack;
                        }
                        return (
                            <tr key={idx}>
                                <td>{list.length - idx}</td>
                                <td>
                                    <span onClick={() => navigate(`/board/detail/${item.boardNum}`)}
                                          className={'table_list_title'}>
                                    <img src={`${photoSrc}`} alt={''} style={{width:'40px',height:'40px'}}/>&nbsp;
                                        {item.title}</span>
                                </td>
                                <td>{item.writer}</td>
                                <td>{item.readcount}</td>
                                <td>{format(item.writeday,'yyyy-MM-dd')}</td>
                            </tr>
                        )
                    })
                }
                </tbody>
            </table>
        </div>
    );
};

export default BoardList;
