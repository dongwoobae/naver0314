import React, {useEffect, useState} from 'react';
import {Alert} from "@mui/material";
import axios from "axios";
import {format} from "date-fns";
import {useNavigate} from "react-router-dom";
import './MyStyle.css';
import noimage from '../image/noimage.jpeg';
import Pagination from 'react-js-pagination';
import styled from "styled-components";

const PaginationBox = styled.div`
  .pagination { display: flex; justify-content: center; margin-top: 15px;}
  ul { list-style: none; padding: 0; }
  ul.pagination li {
    display: inline-block;
    width: 30px;
    height: 30px;
    border: 1px solid #e2e2e2;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1rem; 
  }
  ul.pagination li:first-child{ border-radius: 5px 0 0 5px; }
  ul.pagination li:last-child{ border-radius: 0 5px 5px 0; }
  ul.pagination li a { text-decoration: none; color: #337ab7; font-size: 1rem; }
  ul.pagination li.active a { color: white; }
  ul.pagination li.active { background-color: #337ab7; }
  ul.pagination li a:hover,
  ul.pagination li a.active { color: blue; }
`
const BoardList = () => {
    const thumbnailFront=process.env.REACT_APP_THUMBNAIL;
    const thumbnailBack=process.env.REACT_APP_THUMBNAIL2;
    const [page,setPage]=useState(1);
    const handlePageChange = (page) => { setPage(page); };

    const navigate=useNavigate();
    const [list,setList]=useState([]);
    const callList=()=>{
        axios.get("/boot/board/list").then(res=>{
            setList(res.data);
        });
    }
    let pageCount=list.length/5;
    useEffect(()=>{
        callList();
    },[]);
    return (
        <div>
            <Alert>게시판 목록 - 총 {list.length} 개의 게시글이 있습니다</Alert>
            <table className={'table table-striped'} style={{width: '600px', marginLeft: '20px'}}>
                <thead>
                <tr>
                    <th style={{width: '50px'}}>번호</th>
                    <th style={{width: '250px'}}>제목</th>
                    <th style={{width: '100px'}}>작성자</th>
                    <th>조회수</th>
                    <th style={{width: '120px'}}>작성일</th>
                </tr>
                </thead>
                <tbody>
                {
                    list &&
                    list.map((item, idx) => {
                        let photoSrc = '';
                        if (item.photo === 'no') {
                            photoSrc = noimage;
                        } else {
                            photoSrc = thumbnailFront + "/" + item.photo + thumbnailBack;
                        }
                        return (
                            <tr key={idx}>
                                <td>{list.length - idx}</td>
                                <td>
                                    <span onClick={() => navigate(`/board/detail/${item.boardNum}`)}
                                          className={'table_list_title'}>
                                    <img src={`${photoSrc}`} alt={''} style={{width: '40px', height: '40px'}}/>&nbsp;
                                        {item.title}</span>&nbsp;<span style={{color: 'red'}}
                                                                       hidden={item.answercount === 0}>[{item.answercount}]</span>
                                </td>
                                <td>{item.writer}</td>
                                <td>{item.readcount}</td>
                                <td>{format(item.writeday, 'yyyy-MM-dd')}</td>
                            </tr>
                        )
                    })
                }
                </tbody>
            </table>
            <footer>
                <PaginationBox>
                <Pagination
                    activePage={page}
                    itemsCountPerPage={5}
                    totalItemsCount={list.length}
                    pageRangeDisplayed={5}
                    onChange={handlePageChange}
                    />
                </PaginationBox>
            </footer>
        </div>
    );
};

export default BoardList;
