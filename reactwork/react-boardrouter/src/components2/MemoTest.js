import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import ShowState from "./ShowState";

const MemoTest = () => {
    // 변수 하나만 바뀌어도 전체가 렌더링 되는 것을 막기 위한 기능
    const [number,setNumber]=useState(0);
    const [text,setText]=useState('');
    const increNumber=()=>{
        setNumber(number+1);
    }
    const decreNumber=()=>{
        setNumber(number-1);
    }
    const onChangeTextHandler=(e)=>{
        setText(e.target.value);
    }
    return (
        <div>
        <Alert>memoization test<br/> 렌더링을 최적화 하기 위한 기능</Alert>
        <div style={{fontSize:'2em',margin:'100px 100px'}}>
            <Button variant={'outlined'} color={'success'} onClick={increNumber}>+</Button>&nbsp;
            <Button variant={'outlined'} color={'error'} onClick={decreNumber}>-</Button>
            <br/>
            <input type={'text'} placeholder={'Last Name?'} value={text}
                   onChange={onChangeTextHandler}/>
        </div>
            <ShowState number={number} text={text}/>
        </div>
    );
};

export default MemoTest;
