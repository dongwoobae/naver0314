import "./MyStyle.css";
import React, {useState} from "react";
import car1 from '../mycar1.png';

const FiveApp=()=>{
    const [show, setShow] = useState(true);
    const [fonts, setFonts] = React.useState('Pretendard');
    const [fcolor,setFcolor] = React.useState("red");
    const [bcolor,setBcolor] = React.useState("#afeeee");

    let message="오늘은 리액트를 공부 중 입니다";

    return (
        <div>
            <h1 className={"alert alert-danger"}>Five App 글꼴변경</h1>
            <button type={"button"} className={"btn btn-sm btn-primary"}
                    onClick={() => setShow(!show)}>show/hide
            </button>
            {
                show &&
                <img alt={"Car"} src={car1} style={{width: '200px'}}/>
            }
            <hr/>
            <div style={{fontSize: '30px', color: fcolor, fontFamily: fonts,backgroundColor:bcolor}}>
                {message}
            </div>
            <h5>select 이벤트를 이용해서 글꼴변경하기</h5>
            <select onChange={(e) => setFonts(e.target.value)}
            className={"form-select"} style={{width:'200px'}}>
                <option selected>Pretendard</option>
                <option>궁서체</option>
                <option>East Sea Dokdo</option>
                <option>Gaegu</option>
                <option>Gamja Flower</option>
                <option>Single Day</option>
            </select>
            <select onChange={(e) => setFcolor(e.target.value)}
                    className={"form-select"} style={{width:'200px'}}>
                <option selected>Red</option>
                <option>hotpink</option>
                <option>lightblue</option>
                <option>Blue</option>
                <option>Orange</option>
                <option>purple</option>
            </select>
            &nbsp;&nbsp;
            <label>
                <input type={"radio"} defaultValue={'#afeeee'} name={'bcolor'} defaultChecked
                onClick={(event) => {setBcolor(event.target.value)}}/> 하늘색
            </label>&nbsp;&nbsp;
            <label>
                <input type={"radio"} defaultValue={'#fffacd'} name={'bcolor'}
                       onClick={(event) => {setBcolor(event.target.value)}}/> 노랑색
            </label>&nbsp;&nbsp;
            <label>
                <input type={"radio"} defaultValue={'#90ee90'} name={'bcolor'}
                       onClick={(event) => {setBcolor(event.target.value)}}/> 초록색
            </label>
        </div>
    )
}

export default FiveApp;