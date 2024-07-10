import React, {useRef, useState} from 'react';
import {Alert, Button, ButtonGroup, setRef} from "@mui/material";

//Ref는 useState와 달리 바로바로 렌더링이 되는게 아님.
//용량이 큰 정보들을 처리할 때는 ref로 해야 렉이 안걸림
//단 화면으로는 해당 정보가 바뀐지 몰라서 useRef 만으로는 화면 정보가 바뀌지 않음
//형식 : const ref=useRef(//value);
//값을 가져오려면 ref.current
const ThreeApp = () => {
    const [count,setCount]=useState(1);
    const countRef = useRef(1);
    console.log("렌더링 중...");
    //count 변수 1 증가하는 이벤트
    const countIncre=()=>{
        setCount(count+1);
    }
    const countRefIncre=()=>{
        countRef.current=countRef.current+1;
        console.log(countRef.current);
    }
    return (
        <div>
            <Alert>ThreeApp-useRef</Alert>
            <h1>state 변수 : {count}</h1>
            <h1>ref 변수 : {countRef.current}</h1>
            <ButtonGroup>
                <Button onClick={()=>countIncre()}>s 증가</Button>
                <Button onClick={()=>countRefIncre()}>r 증가</Button>
                <br/>
                <Button onClick={()=>{
                    setCount(1);
                    countRef.current=1;
                }}>초기화</Button>
            </ButtonGroup>
        </div>
    );
};

export default ThreeApp;
