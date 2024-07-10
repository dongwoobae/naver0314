import React from 'react';
import {Button} from "@mui/material";
import {DeleteForeverOutlined} from "@mui/icons-material";

const SixChild2App = ({row,onDelete}) => {

    return (
        <tr>
            <td>{row.cname}</td>
            <td style={{backgroundColor:row.color}}>
                <img src={require(`../image/mycar/${row.cphoto}`)} alt={row.cname} className={'small2'}/>
            </td>
            <td>{row.cprice}만원</td>
            <td><Button variant={'contained'} color={'primary'} startIcon={<DeleteForeverOutlined/>}
            onClick={onDelete}>del</Button></td>
        </tr>
    );
};

export default SixChild2App;
