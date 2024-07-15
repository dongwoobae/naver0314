import React from 'react';
import {DeleteForever} from "@mui/icons-material";

const TwoRowItem = (prop) => {
    let {item,idx,deleteFn}=prop;
    // const dateFormat=(value)=>{
    //     return new Intl.DateTimeFormat('ko-KR', {
    //         year: 'numeric',
    //         month: '2-digit',
    //         day: '2-digit',
    //         hour: '2-digit',
    //         minute: '2-digit',
    //         hour12: true
    //     }).format(value).replace(/(\d{4})-(\d{2})-(\d{2})-\s(\d{2}):(\d{2})/, '$1-$2-$3 $4:$5');
    // };
    const dateFormat = (value) => {
        const pad = (num) => String(num).padStart(2, '0');
        const year = value.getFullYear();
        const month = pad(value.getMonth() + 1);
        const day = pad(value.getDate());
        const hours = pad(value.getHours());
        const minutes = pad(value.getMinutes());
        return `${year}-${month}-${day} ${hours}:${minutes}`;
    };
    return (
        <tr>
           <td># {idx + 1}</td>
            <td>{item.irum}</td>
            <td>{item.age}세</td>
            <td>{item.blood}형</td>
            <td>{dateFormat(item.today)}</td>
            <td><DeleteForever style={{cursor:'pointer',color:'blue'}} onClick={()=>deleteFn(idx)}/></td>
        </tr>
    );
};

export default TwoRowItem;
