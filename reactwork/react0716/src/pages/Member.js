import React from 'react';
import {Alert} from "@mui/material";
import {NavLink, Route, Routes} from "react-router-dom";
import Party1 from "./Party1";
import Party2 from "./Party2";
import Party3 from "./Party3";


const Member = () => {
    return (
        <div>
            <Alert severity="info" style={{fontSize:'20px'}}>
                저의 모임 목록입니다 - 중첩 라우터 공부
            </Alert>
            <img src={require('../image/snoopyAvata/s4.JPG')} alt={''}/>
            <ul className={'menu'}>
                <li>
                    <NavLink to={'/member/party1'}>모임 #1</NavLink>
                </li>
                <li>
                    <NavLink to={'/member/party2'}>모임 #2</NavLink>
                </li>
                <li>
                    <NavLink to={'/member/party3'}>모임 #3</NavLink>
                </li>
            </ul>
            {/*페이지 안에서 특정 부분만 바뀌게 하고 싶을 때*/}
            <div style={{clear: 'both',margin:'20px',width:'300px',backgroundColor:'orange'}}>
                <Routes>
                    <Route path={'party1'} element={<Party1/>}/>
                </Routes>
                <Routes>
                    <Route path={'party2'} element={<Party2/>}/>
                </Routes>
                <Routes>
                    <Route path={'party3'} element={<Party3/>}/>
                </Routes>
            </div>
        </div>
    );
};

export default Member;
