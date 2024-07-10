import React from 'react';
import {Alert} from "@mui/material";
import FiveChildApp from "./FiveChildApp";
import car1 from '../image/mycar/mycar1.png'
import FiveChild2App from "./FiveChild2App";
import car2 from '../image/mycar/mycar2.png'

const FiveApp = () => {
    return (
        <div>
            <Alert severity={'info'}>FiveApp - 부모, 자식 컴포넌트의 통신 #1</Alert>
            <h5>FiveChildApp 컴포넌트 호출</h5>
            <FiveChildApp irum={`이영자`} age={23} addr={'서울시'}/>
            <FiveChildApp irum={`전현무`} age={43} addr={'가평시'}/>
            <FiveChildApp irum={`이성호`} age={29} addr={'성남시'}/>
            <FiveChild2App irum={'ZIPP'} photo={car1} msg={'차차차'}/>
            <FiveChild2App irum={'AVIIAV'} photo={car2} msg={'거거거'}/>
        </div>
    );
};

export default FiveApp;
