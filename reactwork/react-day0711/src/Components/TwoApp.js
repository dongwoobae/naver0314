import React, {useState} from 'react';
import {Alert} from "@mui/material";
import TwoWriteForm from "./TwoWriteForm,";
import TwoRowItem from "./TwoRowItem";

const TwoApp = () => {
    const [dataArray,setDataArray] = useState([
        {irum:'이영자',blood:'AB',age:43,today:new Date()},
        {irum:'이영지',blood:'A',age:29,today:new Date()},
        {irum:'이영호',blood:'B',age:34,today:new Date()}
    ]);
    const deleteData=(idx)=>{
        let a=window.confirm("삭제?");
        if(a){
            setDataArray(dataArray.filter((d,i)=>i!==idx))
        }
    }
    return (
        <div>
            <Alert>TwoApp - 객체 배열 출력 - tr rowSpan</Alert>
            {/*입력폼 컴포넌트*/}
            <TwoWriteForm/>
            <hr/>
            <table className={'table table-bordered'} style={{width:'500px'}}>
                <thead>
                <tr className={'table-danger'}>
                    <th>번호</th>
                    <th>이름</th>
                    <th>나이</th>
                    <th>혈액형</th>
                    <th>등록일</th>
                    <th>삭제</th>
                </tr>
                {
                    dataArray &&
                    dataArray.map((item,idx)=>{
                        return <TwoRowItem item={item} key={idx} idx={idx} deleteFn={deleteData}/>
                    })
                }
                </thead>
            </table>
        </div>
    );
};

export default TwoApp;
