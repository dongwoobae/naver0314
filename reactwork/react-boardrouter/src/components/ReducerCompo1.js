import React, {useReducer, useState} from 'react';
import {Alert, Button} from "@mui/material";

const ACTION_TYPES={
    add:'addmoney',
    sub:'submoney'
}
//첫번째 예제는 간단하게 입출금하는 예제
//action type에 따라 state (money) 값을 변경처리
const reducer=(state,action)=>{
    console.log("reducer(은행) 가 일을 합니다",state,action);
    switch (action.type){
        case ACTION_TYPES.add:
            return state + Number(action.payload);
        case ACTION_TYPES.sub:
            return state - action.payload;
        default:
            return state ;
    }
}
const ReducerCompo1 = () => {
    /*
    useReducer : state 관리가 용이하며 유지, 보수가 편리하다
    호출: 이벤트에서  dispatch (type, action) 로 호출 시 reducer(state,action) 함수가 호출됨
    reducer: state를 업데이트 하는 역할
    dispatch 의 state 업데이트를 요구
    action: 요구의 내용
        */
    const [number, setNumber] = useState(0);
    const [money, dispatch] = useReducer(reducer,0);
    return (
        <div>
            <Alert>reducer 1</Alert>
            <h3>use Reducer 은행에 오신 것을 환영합니다</h3>
            <h3>잔고 : <b>{money}</b></h3>
            <hr/>
            <input type={"number"} value={number} step={1000} onChange={(e)=>{
                setNumber(e.target.value);
            }} className={'form-control'} style={{width:'200px'}}/>
            <Button variant={'contained'} size={'small'} color={'success'} onClick={()=>dispatch({'type':ACTION_TYPES.add, payload:number})}>입금</Button>&emsp;
            <Button variant={'contained'} size={'small'} color={'error'} onClick={()=>dispatch({'type':ACTION_TYPES.sub, payload:number})}>출금</Button>

        </div>
    );
};

export default ReducerCompo1;
