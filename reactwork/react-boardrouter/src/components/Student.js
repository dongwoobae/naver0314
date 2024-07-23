import React from 'react';
import {Button} from "@mui/material";

const Student = ({stu,dispatch}) => {
    return (
        <div className={'input-group'} style={{width:'300px'}}>
            <div style={{textDecoration:stu.isHere?'line-through':'none',width:'100px',cursor:'pointer',
            color:stu.isHere?'gray':'black'}} onClick={()=>{
                dispatch({type:'mark-student',payload:{id:stu.id}});
            }}>
                {stu.name}
            </div>&nbsp;
            <Button variant={'outlined'} size={'small'} color={'warning'} onClick={()=>dispatch({type:'delete-student',payload:{id:stu.id}})}>
                삭제
            </Button>
        </div>
    );
};

export default Student;
