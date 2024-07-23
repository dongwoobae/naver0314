import React, {useMemo} from 'react';
import {Alert} from "@mui/material";

const getNumber=(number)=>{
    console.log('숫자가 변동되었습니다.')
    return number;
}
const getText=(text)=>{
    console.log('글자가 변동되었습니다.')
    return text;
}

const ShowState = ({number,text}) => {
    // const showNumber=getNumber(number);
    // const showText=getText(text);
    const showNumber= useMemo(() => getNumber(number),[number]);
    const showText= useMemo(() => getText(text),[text]);

    return (
        <div>
            <h3>{showNumber}</h3>
            <h4>{showText}</h4>
        </div>
    );
};

export default ShowState;
