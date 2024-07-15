import React from 'react';
import {FormControlLabel, Radio, RadioGroup} from "@mui/material";

const TwoWriteForm = () => {
    const handleChange=(e)=>{
        const{name,value}=e.target;

    }
    return (
        <table className={'table'} style={{width:'400px'}}>
            <tbody>
            <tr>
                <th>이름</th>
                <th>나이</th>
                <th>혈액형</th>
            </tr>
            <tr>
                <td width={150}><input type={'text'} name={'irum'} className={'input-group'}
                onChange={handleChange}/></td>
                <td width={100}><input type={'text'} name={'age'} className={'input-group'}
                onChange={handleChange}/></td>
                <td>
                    <select className={'form-select'} onChange={handleChange}>
                        <option value={'A'}>A형</option>
                        <option value={'B'}>B형</option>
                        <option value={'AB'}>AB형</option>
                        <option value={'O'}>O형</option>
                    </select>
                </td>
            </tr>
            </tbody>
        </table>
    );
};

export default TwoWriteForm;
