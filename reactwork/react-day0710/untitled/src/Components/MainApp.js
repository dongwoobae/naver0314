import React from 'react';
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import SixApp from "./SixApp";
import {FormControlLabel, Radio, RadioGroup} from "@mui/material";
import 'bootstrap/dist/css/bootstrap.min.css';

const MainApp = () => {
    const [idx, setIdx] = React.useState(6);
    const changeApp=(e)=>{
        setIdx(Number(e.target.value));
    }
    return (
        <div>
            <div>
                <RadioGroup name="row-radio-buttons-group" style={{marginLeft:'20px'}}>
                    <FormControlLabel
                        value="1"
                        control={<Radio />}
                        label="OneApp - 배열 추가, 삭제"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="2"
                        control={<Radio />}
                        label="TwoApp - 배열 추가,삭제 문제"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="3"
                        control={<Radio />}
                        label="ThreeApp - useRef 공부하기"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="4"
                        control={<Radio />}
                        label="FourApp useRef 응용 예제"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="5"
                        control={<Radio />}
                        label="FiveApp - 부모 자식간 통신 #1"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="6"
                        control={<Radio />}
                        label="SixApp - 부모 자식간 통신 #2"
                        onChange={changeApp}
                    />

                </RadioGroup>
            </div>
            <hr/>
            {
                idx === 1 ? <OneApp/> : idx === 2 ? <TwoApp/> :
                    idx === 3 ? <ThreeApp/> : idx === 4 ? <FourApp/> :
                        idx===5?<FiveApp/>:<SixApp/>
            }
        </div>
    );
};

export default MainApp;
