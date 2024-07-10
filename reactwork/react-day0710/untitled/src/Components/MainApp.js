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
    const [idx, setIdx] = React.useState(1);
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
                        label="ThreeApp"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="4"
                        control={<Radio />}
                        label="FourApp"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="5"
                        control={<Radio />}
                        label="FiveApp"
                        onChange={changeApp}
                    />
                    <FormControlLabel
                        value="6"
                        control={<Radio />}
                        label="SixApp"
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
