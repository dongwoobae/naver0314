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
            </Routes>
        </div>
    );
};

export default RouterMain;
