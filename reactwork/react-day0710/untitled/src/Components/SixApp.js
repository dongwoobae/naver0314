import React, {useState} from 'react';
import SixChild1App from "./SixChild1App";
import SixChild2App from "./SixChild2App";
import {Alert} from "@mui/material";

const SixApp = () => {
    const [count,setCount]=useState(0);
    const countIncre =()=>{
        setCount(count+1);
    }
    const [array, setArray] = useState([
        {cname:"Audi",cphoto:"mycar2.png",cprice:"7300",color:"#afeeee"},
        {cname:"Genesis",cphoto:"mycar9.png",cprice:"6500",color:"#ffc0cb"},
        {cname:"VolksWagon",cphoto:"mycar12.png",cprice:"4100",color:"bisque"},
        {cname:"BMW mini",cphoto:"mycar7.png",cprice:"5500",color:"#40e0d0"}
    ]);
    //삭제하는 함수(이벤트 함수 안에서 호출되어야 하는 함수, 직접 event를 줄 수는 없음)
    const deleteParentsCar=(idx)=>{
        let a=window.confirm("삭제?");
        if(a) {
            setArray([
                ...array.slice(0, idx),
                ...array.slice(idx + 1, array.length)
            ])
        }
    }
    return (
        <div style={{display:'flex',flexWrap:'wrap'}}>
            <Alert style={{width:'100%'}}>SixApp- 부모자식간의 통신 #2</Alert>
            <Alert severity={'error'} style={{width:'100%',fontSize:'20px'}}>회원 방문 회수: {count} 회</Alert>
            <SixChild1App carname={"아반떼"} carphoto={"mycar8.png"} bgcolor={'#ffc0cb'}
                          carprice={"2500"} onIncre={countIncre}/>
            <SixChild1App carname={"그랜져"} carphoto={"mycar5.png"} bgcolor={'#7fffd4'}
                          carprice={"3500"} onIncre={countIncre}/>
            <SixChild1App carname={"벤츠"} carphoto={"mycar1.png"} bgcolor={'#1ee3ff'}
                          carprice={"7500"} onIncre={countIncre}/>
            <table className={'tbstyle'}>
                <thead>
                <tr style={{backgroundColor: '#f5f5dc'}}>
                    <th style={{width: '100px'}}>자동차명</th>
                    <th style={{width: '120px'}}>자동차 사진</th>
                    <th style={{width: '100px'}}>가격</th>
                    <th style={{width: '80px'}}>삭제</th>
                </tr>
                </thead>
                <tbody>
                {
                    array.map((item,idx)=><SixChild2App
                    row={item} key={idx} onDelete={()=>deleteParentsCar(idx)}/>)
                }
                </tbody>
            </table>
        </div>
    );
};

export default SixApp;
