import React, {useEffect, useState} from 'react';
import {Button} from "@mui/material";

const FiveApp = () => {
    const [number, setNumber]=useState(1);
    const [count,setCount]=useState(100);
    const [show,setShow]=useState(true);
    const [showCount,setShowCount]=useState(true);
    //연달아주면 순서가 없음. 비동기 통신이라 그래서 언제 할건지 정해줘야함.
    // useEffect(()=>{
    //     console.log("1. 처음, 값 변경시 항상 호출")
    // })

    useEffect(() => {
        console.log("2. 처음 딱 한번만 호출")
    },[]);//[]를 넣으면 처음 불러올때 딱 한번만 호출

    useEffect(() => {
        console.log("3. number가 변경될때 호출")
        if(number%3===0){
            setShow(true);
        }else{
            setShow(false);
        }
    },[number]);

    useEffect(() => {
        console.log("4. count가 변경될때 호출")
        if(count%20===0){
            setShowCount(true);
        }else {
            setShowCount(false);
        }
    },[count]);
    return (
        <div>
            <h3 className={"alert alert-primary"}>FiveApp</h3>
            <b style={{fontSize:'30px',color:'red'}}>Number: {number}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant={'contained'} color={'success'}
            onClick={()=>setNumber(number-1)}>Number 감소</Button>
            &nbsp;
            <Button variant={'contained'} color={'success'}
                    onClick={()=>setNumber(number+1)}>Number 증가</Button>
            <hr/>
            <b style={{fontSize:'30px',color:'red'}}>Count : {count}</b>
            &nbsp;&nbsp;&nbsp;
            <Button variant={'contained'} color={'info'}
                    onClick={()=>setCount(count-10)}>Count 감소</Button>
            &nbsp;
            <Button variant={'contained'} color={'info'}
                    onClick={()=>setCount(count+10)}>Count 증가</Button>
                <br/><br/>
                <Button variant={'contained'} color={'secondary'}
                onClick={()=>{
                    setCount(count-10)
                    setNumber(number-1)
                }}>모두 감소</Button>
                &nbsp;
                <Button variant={'contained'} color={'secondary'}
                        onClick={()=>{
                            setCount(count+10)
                            setNumber(number+1)
                        }}>모두 증가</Button>
            <br/><br/><br/>
            {show&&showCount&&
            <img src={require('../image/9.jpg')} alt={'사진'}/>}
        </div>
    );
};

export default FiveApp;