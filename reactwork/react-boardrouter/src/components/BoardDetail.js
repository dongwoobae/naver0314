import React, { useEffect, useState } from 'react';
import {
    Alert,
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogContentText,
    DialogTitle,
    TextField
} from "@mui/material";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import { format } from "date-fns";
import './MyStyle.css';
import InputEmojiWithRef from "react-input-emoji";
import {HighlightOffOutlined, Mode} from "@mui/icons-material";

const BoardDetail = () => {
    const storage = process.env.REACT_APP_STORAGE;
    const { boardNum } = useParams();
    const [selectData, setSelectData] = useState(null);
    const [loading, setLoading] = useState(true);
    const [open, setOpen] = React.useState(false);
    const [open2, setOpen2] = React.useState(false);
    const [comment,setComment]=useState('');
    const [updatedComment, setUpdatedComment] = useState('');
    const [commentList,setCommentList]=useState([]);
    const [error, setError] = useState('');
    const [pass,setPass]=useState('');
    const [nickname,setNickname]=useState('ㅇㅇ');
    const [cPass,setCPass]=useState('');
    const [inputCpass,setInputCpass]=useState('');
    const [visibility,setVisibility]=useState(false);
    const [visibleInputIndex , setVisibleInputIndex ] = useState(null);
    const [delVis, setDelVis] = useState(false);
    const [upVis,setUpVis]=useState(false);
    const [isEditing, setIsEditing] = useState(false);

    const navi=useNavigate();

    const handleClickOpen = () => {
        setOpen(true);
        setPass('');
        setError('');
    };

    const handleClose = () => {
        setOpen(false);
        setPass('');
        setError('');
    };
    const handleClickOpen2 = () => {
        setOpen2(true);
        setPass('');
        setError('');
    };

    const handleClose2 = () => {
        setOpen2(false);
        setPass('');
        setError('');
    };
    const handlePasswordChange = (event) => {
        setPass(event.target.value);
    };
    const handleInputCpassDel=(idx)=>{
        let url=`/boot/boardcomment/pwcheck?idx=${idx}&cpass=${inputCpass}`;
        axios.get(url).then(res=>{
            if(res.data.result==='confirm'){
                axios.delete(`/boot/boardcomment/delete/${idx}`).then(res=>{
                    getCommentData();
                    setVisibleInputIndex('');
                    setInputCpass('');
                    setVisibility(false);
                })
            }else{
                alert('비밀번호 틀림');
                setInputCpass('');
            }
        })
    }
    const handleInputCpassUp=(idx)=>{
        let url=`/boot/boardcomment/pwcheck?idx=${idx}&cpass=${inputCpass}`;
        axios.get(url).then(res=>{
            if (res.data.result==='confirm'){
                const formData=new FormData();
                formData.append('comment',updatedComment);
                axios.put(`/boot/boardcomment/update/${idx}`, formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data',
                    }
                }).then(res=>{
                    getCommentData();
                    setVisibleInputIndex('');
                    setInputCpass('');
                    setVisibility(false);
                    setUpdatedComment('');
                })
            }else {
                alert('비밀번호 틀림');
                setInputCpass('');
            }
        })
    }

    const getData = () => {
        let url = "/boot/board/detail?boardNum=" + boardNum;
        axios.get(url).then(res => {
            setSelectData(res.data);
            setLoading(false);
        }).catch(error => {
            console.error("There was an error fetching the data!", error);
            setLoading(false);
        });
    };
    const getCommentData=()=>{
        let url=`/boot/boardcomment/list?boardNum=${boardNum}`;
        axios.get(url).then(res=>{
            setCommentList(res.data);
        })
    }
    const insertComment=(e)=>{
        const formData=new FormData();
        formData.append('boardNum',boardNum);
        formData.append('nickname',nickname);
        formData.append('cpass',cPass);
        formData.append('comment',comment);

        let url='/boot/boardcomment/insert'

        axios.post(url,formData).then(res=>{
            getCommentData();
            setNickname('');
            setComment('');
            setCPass('');
        })
    }

    useEffect(() => {
        getData();
        getCommentData();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (!selectData) {
        return <div>Error loading data</div>;
    }

    return (
        <div>
            <Alert>상세 보기</Alert>
            <table className={'table table-borderless'} style={{ width: '600px', marginLeft: '20px' }}>
                <tbody>
                <tr>
                    <th colSpan={2}>{selectData.title}</th>
                </tr>
                <tr>
                    <td style={{borderBottom:'1px solid gray'}}>작성자 : {selectData.writer}</td>
                    <td align={'right'} style={{borderBottom:'1px solid gray'}}>
                        조회수: {selectData.readcount}&emsp;
                        작성일 : <span style={{fontSize:'14px',color:'gray'}}>{format(new Date(selectData.writeday), "yyyy-MM-dd HH:mm")}</span>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{borderBottom:'1px solid lightgray'}}>
                        <h5>대표 사진</h5>
                        <img src={`${storage}/${selectData.photo}`} alt={''} style={{maxWidth: '500px'}}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{borderTop:'1px solid gray',borderBottom:'1px solid gray'}}>
                        <pre dangerouslySetInnerHTML={{ __html: selectData.content }} style={{minHeight:'300px'}}></pre>
                    </td>
                </tr>
                <tr>
                    <td align={'right'} colSpan={2} style={{borderBottom:'1px solid gray'}}>
                        <Button variant={'outlined'} color={'success'} onClick={()=>navi('/board/list')}>목록</Button>&emsp;
                        <Button variant={'outlined'} color={'info'} onClick={()=>navi('/board/form')}>글 쓰러 가기</Button>&emsp;
                        <Button variant="outlined" color={'inherit'} onClick={handleClickOpen}>
                            수정
                        </Button>&emsp;
                        <Button variant={'outlined'} color={'error'} onClick={handleClickOpen2}>삭제</Button>
                    </td>
                </tr>
                <tr>
                    <th>댓글</th>
                </tr>
                <tr>
                    <td colSpan={2} style={{borderBottom:'1px solid black'}}>
                        작성자 : <input type={'text'} name={'nickname'} value={nickname} onChange={(e)=>{
                            setNickname(e.target.value);
                    }} style={{width:'100px'}}/>&emsp;비밀번호: <input type={'password'} value={cPass} onChange={(e)=>{
                        setCPass(e.target.value);
                    }} style={{width:'100px'}}/>
                        <InputEmojiWithRef
                            value={comment}
                            onChange={(text)=>{
                                setComment(text);
                            }}
                            cleanOnEnter
                            placeholder={'댓글 입력 후 Enter'}
                            onEnter={insertComment}/>
                    </td>
                </tr>
                {
                    commentList&&
                    commentList.map((comment,idx)=>{
                        return(
                        <>
                            <tr key={idx}>
                                <td colSpan={2}>{comment.nickname}&nbsp;(<span
                                    style={{fontSize: '11px', color: 'rgba(0,0,0,0.6)'}}>{comment.loginip}</span>)&emsp; <span
                                    style={{color: 'gray', fontSize: '0.8em'}}>{comment.writeday}</span>&emsp;
                                    <Mode style={{color:'gray',fontSize:'1em',cursor:'pointer'}}
                                    onClick={()=>{
                                        if(visibleInputIndex!==comment.idx) {
                                            setVisibility(true);
                                            setInputCpass('');
                                            setDelVis(false);
                                            setUpVis(true);
                                            setIsEditing(!isEditing);
                                            setUpdatedComment('');
                                        }else {
                                            if(delVis){
                                                setVisibility(true);
                                                }else {
                                                setVisibility(!visibility);
                                            }
                                            setInputCpass('');
                                            setDelVis(false);
                                            setUpVis(true);
                                            setIsEditing(!isEditing);
                                        }
                                        setVisibleInputIndex(comment.idx);
                                    }}/>&nbsp;
                                    <HighlightOffOutlined style={{fontSize: '1em',color:'gray',cursor:'pointer'}}
                                    onClick={()=>{
                                        if(visibleInputIndex!==comment.idx) {
                                            setVisibility(true);
                                        }else {
                                            if(upVis) {
                                                setVisibility(true)
                                            }else {
                                                setVisibility(!visibility);
                                            }
                                        }
                                        setIsEditing(false);
                                        setDelVis(true);
                                        setUpVis(false);
                                        setInputCpass('');
                                        setVisibleInputIndex(comment.idx);
                                    }}/>&emsp;
                                    {
                                        visibleInputIndex===comment.idx&&visibility&&(
                                            <div style={{display:'inline-flex'}}>
                                        <input type={'password'} style={{width:'150px',fontSize:'small'}} className={'form-control'} placeholder={'댓글 비밀번호'} name={'cpassInput'} value={inputCpass} onChange={(e)=>{
                                        setInputCpass(e.target.value);
                                    }}/>&nbsp;
                                                {
                                                    delVis&&!upVis&&
                                                <button className={'btn btn-outline-info btn-sm'} onClick={()=>handleInputCpassDel(comment.idx)}>확인</button>
                                                }
                                                {
                                                    !delVis&&upVis&&
                                                    <button className={'btn btn-outline-success btn-sm'} onClick={()=>handleInputCpassUp(comment.idx)}>확인</button>
                                                }
                                            </div>
                                )}
                                </td>
                            </tr>
                            <tr>
                            <td colSpan={2} style={{borderBottom:'1px solid lightgray',fontSize:'14px'}}>
                                {isEditing&&visibleInputIndex===comment.idx ? (
                                    <input
                                        type={'text'}
                                        value={updatedComment}
                                        className={'form-control'}
                                        style={{height:'fit-content'}}
                                        placeholder={'댓글 수정'}
                                        onChange={(e) => setUpdatedComment(e.target.value)} // 상태 업데이트 필요
                                    />
                                ) : (
                                    comment.comment
                                )}
                            </td>
                            </tr>
                        </>
                        )
                    })
                }
                </tbody>
            </table>
            {/*수정 dialog*/}
            <React.Fragment>
                 <Dialog
                    open={open}
                    onClose={handleClose}
                    PaperProps={{
                        component: 'form',
                        onSubmit: (event) => {
                            event.preventDefault();
                            const formData = new FormData(event.currentTarget);
                            const formJson = Object.fromEntries(formData.entries());
                            const password = formJson.password;

                            axios.get(`/boot/board/updatecheckpass?boardNum=${boardNum}&pass=${password}`).then(res=>{
                                if (res.data.result==='success'){
                                    navi(`/board/updateForm/${boardNum}`);
                                }else {
                                    setError('비밀번호가 일치하지 않습니다');
                                    setPass('');
                                }
                            })
                        }
                    }}
                >
                    <DialogTitle>글 수정</DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            비밀번호 입력
                        </DialogContentText>
                        <TextField
                            autoFocus
                            required
                            margin="dense"
                            id="standard-password-input"
                            name="password"
                            label="Password"
                            type="password"
                            autoComplete={'current-password'}
                            variant="standard"
                            helperText={error}
                            value={pass}
                            onChange={handlePasswordChange}
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button type="submit">확인</Button>
                        <Button onClick={handleClose}>Cancel</Button>
                    </DialogActions>
                </Dialog>
            </React.Fragment>
            {/*삭제 dialog*/}
            <React.Fragment>
                <Dialog
                    open={open2}
                    onClose={handleClose2}
                    PaperProps={{
                        component: 'form',
                        onSubmit: (event) => {
                            event.preventDefault();
                            const formData = new FormData(event.currentTarget);
                            const formJson = Object.fromEntries(formData.entries());
                            const password = formJson.password;

                            axios.get(`/boot/board/deletecheckpass?boardNum=${boardNum}&pass=${password}`).then(res=>{
                                if (res.data.result==='success'){
                                    let a=window.confirm('삭제하시겠습니까?')
                                    if(a){navi('/board/list');
                                        handleClose2();}
                                }else {
                                    setError('비밀번호가 일치하지 않습니다');
                                    setPass('');
                                }
                            })
                        }
                    }}
                >
                    <DialogTitle>글 삭제</DialogTitle>
                    <DialogContent>
                        <DialogContentText>
                            비밀번호 입력
                        </DialogContentText>
                        <TextField
                            autoFocus
                            required
                            margin="dense"
                            id="standard-password-input"
                            name="password"
                            label="Password"
                            type="password"
                            autoComplete={'current-password'}
                            variant="standard"
                            helperText={error}
                            value={pass}
                            onChange={handlePasswordChange}
                        />
                    </DialogContent>
                    <DialogActions>
                        <Button type="submit">확인</Button>
                        <Button onClick={handleClose2}>Cancel</Button>
                    </DialogActions>
                </Dialog>
            </React.Fragment>
        </div>
    );
};

export default BoardDetail;
