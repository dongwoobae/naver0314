import React from 'react';
import {Alert} from "@mui/material";
import './MyStyle.css';

const SevenApp = () => {
    let array1=new Array(12);
    let foodArray=[
        {fname:"샌드위치",price:12000,photo:"15.jpg"},
        {fname:"망고빙수",price:16000,photo:"11.jpg"},
        {fname:"육개장",price:9000,photo:"13.jpg"}
    ]
    return (
        <div>
            <Alert>SevenApp-map 반복문</Alert>
            <h5>image의 1.jpg~ 12.jpg 까지 이미지 출력</h5>
            {
                [...array1].map((item, idx) => {
                    return <img key={idx} src={require(`../image/${idx + 1}.jpg`)} alt="사진" className={'photo'}/>
                })
            }
            <hr/>
            <h5>image의 1.jpg~ 20.jpg 까지 이미지 출력</h5>
            {
                [...new Array(20)].map((item, idx) => {
                    return <img src={require(`../image/${idx + 1}.jpg`)} alt={"사진"} className={'photo'}/>
                })
            }
            <h5>figure로 배열안의 요소들 출력해보기</h5>
            {
                [...foodArray].map((item,idx)=>{
                    return <figure key={idx}>
                        <img key={idx} src={require(`../image/${item.photo}`)} className={'photo'}/>
                        <figcaption>
                            <h6>{item.fname}</h6>{item.price}원</figcaption>
                    </figure>
                })
            }
        </div>
    );
};

export default SevenApp;
