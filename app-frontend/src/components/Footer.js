import React from "react";
import { Container, Row, Col } from "react-bootstrap";
function Footer() {
  return (
    <footer
      className="footer "
      style={{
        backgroundImage: "linear-gradient(0deg, #FFFFFF 0%, #D1D2D5 90%)",
        paddingTop: "20px",
        paddingBottom: "20px",
      }}
    >
      <Row className="container d-flex flex-row justify-content-between">
        <Col className="box2">
          <p>The Problem</p>
          <p>Our Solution</p>
          <p>Our Impact</p>
        </Col>
        <Col className="box2">
          <p>Careers</p>
          <p>About Us</p>
        </Col>
        <Col className="box2">
          <p>Contact Us</p>
          <p>Policy</p>
        </Col>
      </Row>
    </footer>
  );
}
export default Footer;
