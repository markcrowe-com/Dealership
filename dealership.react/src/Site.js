import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import Top10CarListComponent from "./Top10CarListComponent";

export default function Site() {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">Home</Link>
            </li>
            <li>
              <Link to="/lookup">Look up Car Registration Details</Link>
            </li>
            <li>
              <Link to="/cars">Cars</Link>
            </li>
          </ul>
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          <Route path="/lookup">
            <Lookup />
          </Route>
          <Route path="/cars">
            <Cars />
          </Route>
          <Route path="/">
            <Home />
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function Lookup() {
  return <h2>Look up Car Registration Details</h2>;
}

function Cars() {
  return (
    <div>
      <h2>Top 10 valued Cars</h2>
      <Top10CarListComponent />
    </div>
  );
}