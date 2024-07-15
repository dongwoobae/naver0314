import React, {useEffect} from 'react';
import {DeleteForever, EditNote} from "@mui/icons-material";
import {Slide} from "@mui/material";
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogTitle from "@mui/material/DialogTitle";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogActions from "@mui/material/DialogActions";
import axios from "axios";
import myCarList from "./MyCarList";

const directions = ['up', 'down', 'left', 'right'];

function getRandomDirection() {
    return directions[Math.floor(Math.random() * directions.length)];
}
const Transition = React.forwardRef(function Transition(props, ref) {
    const randomDirection=getRandomDirection();
    return <Slide direction={randomDirection} ref={ref} {...props} />;
});
const formatCurrency = (value) =>{
    return new Intl.NumberFormat('ko-KR',{style:'currency',currency:'KRW'}).format(value);
}


const MyCarRowItems = ({idx,row,onDelete,onUpdate}) => {

    const photopath1="https://ql47trrg3710.edge.naverncp.com/UBBjOlMItt/MyCarPhotos/";
    const photopath2="?type=f&w=40&h=40&faceopt=true&ttype=jpg";
    const photopath="https://kr.object.ncloudstorage.com/mycar/MyCarPhotos";

    const [carname, setCarname] = React.useState('');
    const [carprice, setCarprice] = React.useState('');
    const [carcolor, setCarcolor] = React.useState('');

    useEffect(()=>{
        setCarname(row.carname);
        setCarprice(row.carprice);
        setCarcolor(row.carcolor);
    },[]);

    const [open, setOpen] = React.useState(false);

    const handleClickOpen = () => {
        setOpen(true);
    };

    const handleClose = () => {
        setOpen(false);
    };
    const [open2, setOpen2] = React.useState(false);

    const handleClickOpen2 = () => {
        setOpen2(true);
    };

    const handleClose2 = () => {
        setOpen2(false);
    };
    //수정 이벤트
    const updateMycarEvent=()=>{
        //carname의 column 명이 carnmae으로 할거라 생략가능
        onUpdate({num:row.num,carname,carprice,carcolor});
        setOpen2(false);
    }
    return (
        <tr style={{fontSize:'14px'}}>
            <td>
                {row.carname}<br/>
                <img src={`${photopath1}${row.carphoto}${photopath2}`} alt={row.carname} border={1} hspace={3}
                onClick={handleClickOpen}/>
            </td>
            <td>
                {formatCurrency(row.carprice)}
            </td>
            <td>
                <div style={{width:'40px',height:'40px',backgroundColor:row.carcolor,border:'1px solid black'}}></div>
            </td>
            <td>
                {row.carguip}
            </td>
            <td>
                <span style={{color:'gray',fontSize:'11px'}}>{row.writeday}</span><br/>
                <span  style={{display:'flex',justifyContent:'space-between'}}>
                     &nbsp;<EditNote onClick={handleClickOpen2} style={{cursor:'pointer'}}/>
                <DeleteForever onClick={()=>onDelete(row.num,row.carphoto)} style={{color:'red',cursor:'pointer'}}/>
               </span>
            </td>
            {/*원본 사진 확인 다이얼로그*/}
            <React.Fragment>
                <Dialog
                    open={open}
                    TransitionComponent={Transition}
                    keepMounted
                    onClose={handleClose}
                    aria-describedby="alert-dialog-slide-description"
                >
                    <DialogTitle><b>{row.carname}</b></DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-slide-description">
                            <img src={`${photopath}/${row.carphoto}`} alt={row.carname} style={{maxWidth:'500px'}}/>
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button variant={'contained'} color={'error'} onClick={handleClose}>Close</Button>
                    </DialogActions>
                </Dialog>
            </React.Fragment>
            {/*수정 창 다이얼로그*/}
            <React.Fragment>
                <Dialog
                    open={open2}
                    TransitionComponent={Transition}
                    keepMounted
                    onClose={handleClose2}
                    aria-describedby="alert-dialog-slide-description"
                >
                    <DialogTitle><b>자동차 정보 수정</b></DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-slide-description">
                            <table className="table table-striped" style={{width: '300px'}}>
                                <tbody>
                                <tr>
                                    <td className={'table-success'} style={{width: '100px'}}>자동차명</td>
                                    <td style={{width: '200px'}}><input type={'text'} className={'form-control'}
                                                                        style={{width: '200px'}} value={carname}
                                                                        onChange={(e) => setCarname(e.target.value)}/>
                                    </td>
                                </tr>
                                <tr>
                                    <td className={'table-success'} style={{width: '100px'}}>가격</td>
                                    <td><input type={'text'} className={'form-control'}
                                               style={{width: '200px'}} value={carprice}
                                               onChange={(e) => setCarprice(e.target.value)}/></td>
                                </tr>
                                <tr>
                                    <td className={'table-success'} style={{width: '100px'}}>색상</td>
                                    <td><input type={'color'} className={'input-group'}
                                               style={{width: '200px'}} value={carcolor}
                                               onChange={(e) => setCarcolor(e.target.value)}/></td>
                                </tr>
                                <tr>
                                    <td colSpan={2} align={'center'}>
                                        <Button variant={'outlined'} onClick={updateMycarEvent}>수정하기</Button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button variant={'contained'} color={'error'} onClick={handleClose2}>닫기</Button>
                    </DialogActions>
                </Dialog>
            </React.Fragment>
        </tr>
    );
};

export default MyCarRowItems;
