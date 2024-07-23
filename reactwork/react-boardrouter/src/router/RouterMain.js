import React from 'react';
import '../components/MyStyle.css';
import Menu from "../components/Menu";
import {Route, Routes} from "react-router-dom";
import Home from "../components/Home";
import BoardForm from "../components/BoardForm";
import BoardList from "../components/BoardList";
import BoardDetail from "../components/BoardDetail";
import 'bootstrap/dist/css/bootstrap.min.css';
import UpdatePassForm from "../components/UpdatePassForm";
import DaumPostApp from "../components/DaumPostApp";
import SweetAlertApp from "../components/SweetAlertApp";
import ReducerCompo1 from "../components/ReducerCompo1";
import ReducerCompo2 from "../components/ReducerCompo2";
import MemoTest from "../components2/MemoTest";
import CallbackTest from "../components2/callbackTest";

const RouterMain = () => {
    return (
        <div>
            <Menu/>
            <hr style={{clear:'both'}}/>
            <Routes>
                <Route path={'/'} element={<Home/>}/>
                <Route path={'/board'}>
                    <Route path={'form'} element={<BoardForm/>}/>
                    <Route path={'list'} element={<BoardList/>}/>
                    <Route path={'detail/:boardNum'} element={<BoardDetail/>}/>
                    <Route path={'updateForm/:boardNum'} element={<UpdatePassForm/>}/>
                </Route>
                <Route path={'/post'} element={<DaumPostApp/>}/>
                <Route path={'/sweet'} element={<SweetAlertApp/>}/>
                <Route path={'/reducer1'} element={<ReducerCompo1/>}/>
                <Route path={'/reducer2'} element={<ReducerCompo2/>}/>
                <Route path={'/memo'} element={<MemoTest/>}/>
                <Route path={'/callback'} element={<CallbackTest/>}/>
            </Routes>
        </div>
    );
};

export default RouterMain;
