import React from 'react';
import './MyStyle.css';

const FiveChildApp = (props) => {
    return (
        <div className={'box1'}>
            <h4>{props.irum}</h4>
            <h5>{props.age}세 {props.addr}</h5>
        </div>
    );
};

export default FiveChildApp;
