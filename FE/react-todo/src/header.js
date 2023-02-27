import { Container, NavbarBrand } from "react-bootstrap";
import { Navbar } from "react-bootstrap";

function Header(){
    return(
        <Navbar bg="light" sticky="top" className="Header">
            <Container>
                <NavbarBrand>To Do App</NavbarBrand>
            </Container>
        </Navbar>
    )
}

export default Header;