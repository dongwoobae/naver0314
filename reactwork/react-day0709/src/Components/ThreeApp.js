import React from 'react';
import {Alert, Card, Switch} from "@mui/material";
import img1 from '../image/17.jpg';
import img2 from '../image/12.jpg';

const ThreeApp = () => {
    const [show, setShow] = React.useState(true);
    const [visible, setVisible] = React.useState('visible');
    const photoStyle={
        width:'150px',
        border:'1px solid gray',
        borderRadius:'100px'
    }
    const photoCheckEvent=(e)=>{
        setShow(e.target.checked);
    }
    const photoSwitchEvent=(e)=>{
        setVisible(e.target.checked?'visible':'hidden');
    }
    return (
        <div>
            <Alert severity={"info"}>ThreeApp</Alert>
            <Alert>이미지 show/hide</Alert>
            <label>
                <input type={"checkbox"} defaultChecked onClick={photoCheckEvent}/>사진 1 보이기
            </label>
            <Card variant={"outlined"}></Card>
            <br/>
            {show &&
                <img alt={""} src={img1} style={photoStyle}/>}
            <hr/>
            사진 2 보이기<Switch color={"primary"} defaultChecked={show} onChange={photoSwitchEvent}></Switch><br/>
            <img alt={""} src={img2} style={{width:'200px',visibility:visible}}/>
        </div>
    );
};

export default ThreeApp;