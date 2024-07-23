import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import Swal from "sweetalert2";
import xmas1 from '../image/xmas/santa.gif';
import tree1 from '../image/xmas/tree1.gif';
import tree2 from '../image/xmas/tree2.gif';
import tree3 from '../image/xmas/tree3.gif';
import bell1 from '../image/xmas/bell2.gif';

const SweetAlertApp = () => {
    const [sangpum,setSangpum]=useState('애플워치');
    const sweetAlertEvent1=()=>{
        Swal.fire('안녕하세요'); // 기본
    }
    const sweetAlertEvent2=()=>{
        Swal.fire({
            title:'Swal Test Two',
            html:'줄바꿈을 해볼까요 <br/><hr/> 줄바꿈 확인',
            icon:"warning",
            confirmButtonText:'확인',
            confirmButtonColor:'#abcabc',
            cancelButtonText:'취소',
            showCancelButton:true,
            showDenyButton:true,
            showLoaderOnConfirm:true,
            showCloseButton:true
        }).then(res=>{
            if(res.isConfirmed){
                Swal.fire('굿');
            }else if(res.isDenied){
                Swal.fire('deny');
            }else if(res.isDismissed){
                Swal.fire('dismiss');
            }
        })
    }
    const sweetAlertEvent3=()=> {
        Swal.fire({
            title:'사진 넣기',
            html:'<h5>사진을 넣어보세요</h5>' +
                `<img src=${tree1} alt=""/>`,
            imageUrl:xmas1,
            icon:'error'
        })
    }
    const sweetAlertEvent4=()=>{
        Swal.fire({
            title:'input Email Address',
            input:'email',
            inputPlaceholder:'email 작성',
            showCloseButton:true,
            showCancelButton:true
        }).then(res=>{
            console.log(res.value);
        })
    }
    const sweetAlertEvent5=()=>{
        Swal.fire({
            title:'상품 구매',
            imageUrl:'../logo192.png',
            text:`[${sangpum}] 상품을 구매하시겠습니까?`,
            showCancelButton:true,
            cancelButtonText:'cancel'
        }).then(res=>{
            if(res.isConfirmed){
                Swal.fire({
                    text:`[${sangpum}] 상품을 구매하였습니다`
                })
            }
        })
    }
    const sweetAlertEvent6=()=>{
        let arr=[
            {photo:tree1,msg:'루컨'},
            {photo:tree2,msg:'마깃'},
            {photo:tree3,msg:'고근'},
            {photo:bell1,msg:'몽벨'}
        ]
        let s="";
        for(let a of arr){
            s+=`
            <img alt='' src=${a.photo} width="40"/>&emsp;
            <b>${a.msg}</b><br/>
            `
        }
        Swal.fire({
            icon:'info',
            title:'옵션',
            html:s
        });
    }
    return (
        <div>
            <Alert>스위트 알러트</Alert>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent1}>SweetAlert #1</Button>
            <br/><br/>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent2}>SweetAlert #2</Button>
            <br/><br/>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent3}>SweetAlert #3</Button>
            <br/><br/>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent4}>SweetAlert #4</Button>
            <br/><br/>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent5}>SweetAlert #5</Button>
            <br/><br/>
            <Button variant="contained" color="primary" size={'small'} onClick={sweetAlertEvent6}>SweetAlert #6</Button>
            <br/><br/>
        </div>
    );
};

export default SweetAlertApp;
