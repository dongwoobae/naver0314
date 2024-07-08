import './MyStyle.css';
import {useState} from "react";

const ThreeApp =()=>{
    const [number,setNumber]=useState(0);

    const numberStyle={
        fontSize:40,marginLeft:100,color:'red',textShadow:'3px 3px 3px gray',
        marginBottom:10
    }
    return <div>
        <h1 className={'alert alert-info'}>ThreeApp-function Plus Minus</h1>
        <div style={numberStyle}>{number}</div>
        <button className={"btn btn-outline-success"} style={{marginLeft:60}}>Num 증가</button>
        <button className={"btn btn-secondary"} style={{marginLeft:10}}>Num 감소</button>
    </div>;
}

export default ThreeApp;