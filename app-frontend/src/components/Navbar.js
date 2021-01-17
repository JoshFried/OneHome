import React from "react";
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
function StyledNavbar() {
  return (
    <div style={{ marginBottom: "100px" }}>
      <Jumbotron
        fluid
        style={{
          paddingBottom: "15px",
          paddingTop: "20px",
          backgroundColor: "#A0A9B2",
          marginBottom: "0px",
        }}
      >
        <Image
          src="/pictures/logo-A0A9B2.jpg"
          style={{ paddingLeft: "30px", width: "40%", height: "auto" }}
        ></Image>
      </Jumbotron>
      <Navbar
        collapseOnSelect
        expand="lg"
        style={{
          backgroundImage: "linear-gradient(15deg, #223042 0%, #5E7898 90%)",
          height: "60px",
        }}
        variant="dark"
      >
        <Navbar.Brand href="/" style={{ color: "#B4CBE7" }}>
          {" "}
          We are here for you!
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="mr-auto py-3 ">
            <Nav.Link href="/login">Login</Nav.Link>
            <Nav.Link href="/registershelter">Verify Your Shelter</Nav.Link>
            <NavDropdown title="Resources" id="collasible-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Food Bank</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Social Services
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">
                Clothes Banks
              </NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Crisis HotLines
              </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link href="/search">Shelters near you</Nav.Link>
            <Nav.Link href="/help">How to help</Nav.Link>
          </Nav>
          <Nav>
            <Nav.Link href="/about" style={{ color: "#26282B" }}>
              About us
            </Nav.Link>
            <Nav.Link
              eventKey={2}
              href="/contactus"
              style={{ color: "#26282B" }}
            >
              Contact Us
            </Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    </div>
  );
}
export default StyledNavbar;
