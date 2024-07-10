import React from 'react';
import {Button} from "@mui/material";

const SixChild1App = (prop) => {
    return (
        <div className={'box2'} style={{backgroundColor:prop.bgcolor}}>
            <img src={require(`../image/mycar/${prop.carphoto}`)} alt={prop.carname} className={'small2'}/>
            <h4>{prop.carname}</h4>
            <h5>{prop.carprice}만원</h5>
            <Button variant={'outlined'} color={'error'} size={'small'} onClick={prop.onIncre}>방문</Button>
        </div>
    );
};

export default SixChild1App;
