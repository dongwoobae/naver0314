import React, {useState} from 'react';
import {Button} from "@mui/material";

const TwoApp = () => {
    const [names,setNames]=useState(['제논','아란','은월']);
    const [inputValue,setInputValue]=useState('');
    const addNames=()=>{
        if(inputValue.trim()===''){
            alert('내용 입력 요망');
            setInputValue('');
            return
        }
        setNames(names.concat(inputValue));
        setInputValue('');
    }
    const inputStorage=(e)=>{
        setInputValue(e.target.value);
    }
    const deleteNames=(idx,name)=>{
        let a=window.confirm(name+' 삭제');
        if(a) {
            setNames(names.filter((name, index) => index !== idx));
        }
    }
    return (
        <div>
            이름 입력: <input type={"text"} onChange={inputStorage} value={inputValue}/>&nbsp;<Button variant={'outlined'} color={'error'} onClick={addNames}>추가</Button>&nbsp;
            <Button variant={'outlined'} color={'secondary'} onClick={()=>setNames([])}>모두 삭제</Button>
            <hr style={{width:'500px'}}/>
            {
                names &&
                names.map((name,idx)=>{
                    return <h5 key={idx} style={{marginLeft:'80px',display:'flex',justifyContent:'space-between',width:'240px'}}>
                        {name}&nbsp;<button className={'btn btn-success btn-sm'} onClick={()=>deleteNames(idx,name)}>삭제</button>
                    </h5>
                })
            }
        </div>
    );
};

export default TwoApp;
