import React, {useState} from 'react';
import {Alert, Button, Dialog, DialogActions, DialogContent, DialogContentText, DialogTitle} from "@mui/material";
import DaumPostcode from 'react-daum-postcode';

const DaumPostApp = () => {
    const [openPostCode,setOpenPostCode]=useState(false);
    const [address, setAddress] = useState('');
    const [open, setOpen] = React.useState(false);
    const handleClickOpen = () => {
        setOpen(true);
        addrHandle.clickButton2();
    };

    const handleClose = () => {
        setOpen(false);
    };


    const [openPostCode2,setOpenPostCode2]=useState(false);
    const [address2, setAddress2] = useState('');

    const addrHandle={
        clickButton:()=>{
            setOpenPostCode(current=>!current);
        },
        //주소 선택 이벤트
        selectAddress:(data)=>{
            console.dir(data);
            setAddress(`
            주소 : ${data.address}
            우편번호 : ${data.zonecode}
            아파트/빌딩 명: ${data.buildingName}
            영문 주소: ${data.jibunAddressEnglish}
            `);
            setOpenPostCode(false);
        },
        clickButton2:()=>{
            setOpenPostCode2(current=>!current);
        },
        //주소 선택 이벤트
        selectAddress2:(data)=>{
            console.dir(data);
            setAddress2(`
            주소 : ${data.address}
            우편번호 : ${data.zonecode}
            아파트/빌딩 명: ${data.buildingName}
            영문 주소: ${data.jibunAddressEnglish}
            `);
            setOpenPostCode2(false);
            handleClose();
        }
    }
    return (
        <div>
            <Alert>카카오 주소</Alert>
            <h4>카카오 주소 나타내기 #1</h4>
            <Button variant={'contained'} color={'info'} size={'small'} onClick={addrHandle.clickButton}>주소 검색</Button>
            <pre><h5>{address}</h5></pre>
            {
                openPostCode &&
                <DaumPostcode
                    onComplete={addrHandle.selectAddress}// 값을 선택할 경우 실행되는 이벤트
                    autoClose={false} //값을 선택할 경우 사용되는 DOM 을 제거하여 자동닫힘 설정
                    defaultQuery={'강남대로 94길 20'} //팝업을 열때 기본적으로 입력되는 검색어
                />
            }
            <hr/>
            <h4>카카오 주소 나타내기 #2</h4>
            <Button variant="outlined" onClick={handleClickOpen}>
                주소 검색
            </Button>
            <pre><h5>{address2}</h5></pre>
            <React.Fragment>
                <Dialog
                    fullWidth
                    maxWidth={"md"}
                    open={open}
                    onClose={handleClose}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                >
                    <DialogTitle id="alert-dialog-title">
                        {"카카오 주소검색"}
                    </DialogTitle>
                    <DialogContent>
                        <DialogContentText id="alert-dialog-description">
                            <DaumPostcode
                                onComplete={addrHandle.selectAddress2}// 값을 선택할 경우 실행되는 이벤트
                                autoClose={false} //값을 선택할 경우 사용되는 DOM 을 제거하여 자동닫힘 설정
                                defaultQuery={'반포 자이'} //팝업을 열때 기본적으로 입력되는 검색어
                            />
                        </DialogContentText>
                    </DialogContent>
                    <DialogActions>
                        <Button onClick={handleClose}>Disagree</Button>
                        <Button onClick={handleClose} autoFocus>
                            Agree
                        </Button>
                    </DialogActions>
                </Dialog>
            </React.Fragment>

        </div>
    );
};

export default DaumPostApp;
