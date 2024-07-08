import './MyStyle.css';
import {useState} from "react";

const ThreeApp =()=>{
    let [number,setNumber]=useState(0);


    const numberStyle={
        fontSize:40,marginLeft:100,color:'red',textShadow:'3px 3px 3px gray',
        marginBottom:10
    }
    return <div>
        <h1 className={'alert alert-info'}>ThreeApp-function Plus Minus</h1>
        <div style={numberStyle}>{number}</div>
        <button className={"btn btn-outline-success"} style={{marginLeft:60}}
        onClick={()=>{
            setNumber(number+1)//number 변수값 1 증가 코드가 한줄 일때는 굳이 중괄호 안해도 됨
             }}>Num 증가</button>
        <button className={"btn btn-secondary"} style={{marginLeft:10}}
        onClick={()=>setNumber(number-1)}>Num 감소</button>
    </div>;
}

export default ThreeApp;