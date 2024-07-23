import React from 'react';
import {useNavigate} from "react-router-dom";

const Menu = () => {
    const navigate = useNavigate();

    const handleLiClick = (path) => {
        navigate(path);
    };
    return (
        <div>
            <ul className="mainMenu">
                <li onClick={() => handleLiClick('/')}>
                    Home
                </li>
                <li onClick={() => handleLiClick('/board/list')}>
                    List
                </li>
                <li onClick={() => handleLiClick('/board/form')}>
                    WriteForm
                </li>
                <li onClick={() => handleLiClick('/post')}>
                    Post
                </li>
                <li onClick={() => handleLiClick('/sweet')}>
                    SweetAlert
                </li>
                <li onClick={() => handleLiClick('/reducer1')}>
                    Reducer1
                </li>
                <li onClick={() => handleLiClick('/reducer2')}>
                    Reducer2
                </li>
                <li onClick={() => handleLiClick('/memo')}>
                    useMemo
                </li>
                <li onClick={() => handleLiClick('/callback')}>
                    callback
                </li>
            </ul>
        </div>
    );
};

export default Menu;
