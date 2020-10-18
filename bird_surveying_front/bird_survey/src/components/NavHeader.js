import React from 'react';

const NavHeader = (props) => {
  return (
    <header>
        <h1 className="navTitle">Bird Surveying App</h1>
      <ul>
        <li className="nav">
          <a href="/">Home</a>
        </li>
        <li className="nav">
          <a href="/visits/new"> New Survey Visit</a>
        </li>
      </ul>
    </header>
  )
}

export default NavHeader;