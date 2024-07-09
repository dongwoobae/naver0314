import React from 'react';
import {Alert} from "@mui/material";
import './MyStyle.css';

const EightApp = () => {
    const personArray=[
        {pname:"전지현",photo:"8.jpg",addr:"제주도 애월읍",age:45},
        {pname:"설현",photo:"15.jpg",addr:"부산 해운대구",age:26},
        {pname:"신민아",photo:"17.jpg",addr:"서울시 강남구",age:31},
        {pname:"수지",photo:"19.jpg",addr:"서울시 여의도",age:29},
        {pname:"강동원",photo:"9.jpg",addr:"경기도 용인시",age:41},
    ]
    return (
        <div>
            <Alert>EightApp-table을 이용해서 출력</Alert>
            <div style={{display:"flex"}}>
            {
                personArray.map((item, idx) => {
                    return <div style={{marginLeft:'30px',border:'2px solid gray',borderRadius:'20px',padding:'20px'}}>
                        <h5>{idx + 1}번</h5>
                        <img src={require(`../image/${item.photo}`)} alt={'연예인 사진'} className={'photo'}/>
                        <h5>이름: {item.pname}</h5>
                        <h5>주소: {item.addr}</h5>
                        <h5>나이: {item.age}세</h5>
                        </div>
                })
            }
            </div>
        </div>
    );
};

export default EightApp;
