import React, { Fragment } from "react";
import FormInput from "./FormInput.js";
import "../CSS/homepage.css";
import useFormValidation from "./UseFormValidation.js";
import ValidateAuthentication from "./ValidateAuthentication.js";
import { authenticate } from "./AuthenticationService.js";
import { useAuth } from "./Auth.js";
import { useHistory } from "react-router-dom";
import { Link } from "react-router-dom";
import { useUser } from "./UserContext.js";
import { StyledButton } from "./StyledButton.js";
import { Example } from "./Example";
import {
  Navbar,
  Image,
  NavbarBrandProps,
  Jumbotron,
  NavbarProps,
  NavLink,
  Nav,
  NavDropdown,
  Form,
  FormControl,
  Container,
  Row,
  Col,
} from "react-bootstrap";
import "react-bootstrap/Navbar";

const INITIAL_STATE = {
  username: "",
  password: "",
};
const LoginForm = () => {
  return (
    <Fragment>
      <Container style={{ width: "90%", height: "auto" }}>
        <div
          className="linebox container flex"
          style={{ width: "90%", height: "auto", marginTop: "20px" }}
        >
          {" "}
          <Image
            src="/pictures/image.png"
            style={{ width: "100%", height: "auto" }}
          ></Image>
          {/* <div style={{ display: "flex" }}> */}
          {/* <div
              className="box1"
              style={{ alignItems: "flex-start", justifyContent: "flex-start" }}
            ></div> */}
          <div
            className="box1 "
            style={{
              alignItems: "flex-end",
              justifyContent: "flex-end",
              // marginTop: "100px",
              width: "100%",
              marginTop: "100px",
              marginBottom: "100px",
            }}
          >
            <p>
              <h3 style={{ marginBottom: "50px" }}>Canada is a reality</h3>
              <div>
                Twenty per cent of Canada’s homeless population consists of
                young people between the ages of 13 to 24, and at least 6,000
                young people experience homelessness every night.
              </div>
              Most of Canada's young homeless population gravitate to big
              cities, but homelessness also occurs in other communities, it's
              just less visible. And the problem starts early. Forty per cent of
              homeless youth first experience homelessness before the age of 16
            </p>
          </div>
          {/* </div> */}
          <Row
            className="box "
            style={{
              height: "30%",
              borderTop: "solid",
              borderBottom: "solid",
              marginBottom: "300px",
              fontSize: "20px",
              padding: "10px",
            }}
          >
            <p style={{ marginTop: "50px" }}>
              These numbers are tragic.
              The reality of our cities inspired the creation of One Home.
            </p>
            <p>
              We wanted to help every person in need around the world, assist them to find
              the nearest shelter and access the
              closest local resources as quickly as possible.
            </p>
            <p style={{ marginBottom: "50px" }}>
              Beyond finding four walls for shelter, organizations can use our platform to signal the services they offer
              as well as their inventory for food, clothes, and vacant beds. This should save you a trip to a full shelter when you need a bed,
              a trip to a shelter out of food when you are hungry, a walk to a shelter without medical services when you are in pain.

            </p>
          </Row>
        </div>
      </Container>
    </Fragment>
  );
};
export default LoginForm;
