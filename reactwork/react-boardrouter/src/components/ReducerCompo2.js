import React, {useReducer, useState} from 'react';
import {Alert, Button} from "@mui/material";
import Student from "./Student";
import Swal from "sweetalert2";

const initialState = {
    count:2,
    students:[
        {
            id:new Date(),
            name:'한수원',
            isHere:false
        },
        {
            id:new Date(),
            name:'한정우',
            isHere:true
        }
    ]
}
const reducer=(state,action)=>{
    switch (action.type){
        case 'add-student':
            //payload를 통해서 name을 전달받을 예정
            const name=action.payload.name;
            //추가 할 학생 정보 구성
            const addStudent={
                id:new Date(),
                // name:name.
                //key 값과 value 값이 같을 때는 한번만 써도 됨
                name,
                isHere:false
            }
            return {
                count: state.count + 1,
                students: [
                    ...state.students,
                    addStudent
                ]
            };
        case 'delete-student':
            return {
                count: state.count-1,
                students: state.students.filter(s=>s.id!==action.payload.id)
            };
        case 'mark-student':
            return {
                count:state.count,
                students: state.students.map(s=>{
                    if(s.id===action.payload.id){
                        return{
                            ...s,
                            isHere: !s.isHere
                        }
                    }
                    return s;
                })
            }
        default:
            return state;
    }
}
const ReducerCompo2 = () => {
    const [name, setName] = useState('');
    const [studentINfo, dispatch] = useReducer(reducer,initialState);
    // const addStudent
    const addStudent = () => {
        if (name.trim() === '') {
            Swal.fire('이름 입력');
            setName('');
            return
        }
        dispatch({ type: 'add-student', payload: { name } });
        setName('');
    };
    
    return (
        <div>
            <Alert>reducer 2</Alert>
            <h4>총 학생수 : {studentINfo.count} 명</h4>
            <div className={'input-group'} style={{width:'230px'}}>
                <input type={'text'} className={'form-control'} value={name} onKeyDown={(e)=>{
                    if(e.key==='Enter') {addStudent()}
                }}
                       onChange={(e)=>setName(e.target.value)}/>
                <Button variant={'outlined'} color={'error'} size={'small'}
                onClick={()=>{addStudent()
                }}>추가</Button>
            </div>
            <div className={'input-group'} style={{width:'300px',marginTop:'20px'}}>
                <h5>학생 목록 출력</h5>
                {
                    studentINfo.students.map((stu,idx)=><Student key={idx} stu={stu} dispatch={dispatch}/>)
                }
            </div>
        </div>
    );
};

export default ReducerCompo2;
