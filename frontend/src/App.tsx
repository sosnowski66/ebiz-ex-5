import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Box, Container, Fab, Typography } from "@mui/material";
import Navbar from "./components/Navbar/Navbar";
import ScrollTop from "./components/ScrollToTop/ScrollTop";
import { KeyboardArrowUp } from "@mui/icons-material";



function App() {
  return (
    <div>
        <Navbar/>
        <Container>
            <Box sx={{ my: 2 }}>
                {[...new Array(50)]
                    .map(
                        () => `Cras mattis consectetur purus sit amet fermentum.
Cras justo odio, dapibus ac facilisis in, egestas eget quam.
Morbi leo risus, porta ac consectetur ac, vestibulum at eros.
Praesent commodo cursus magna, vel scelerisque nisl consectetur et.`,
                    )
                    .join('\n')}
            </Box>
        </Container>
        <ScrollTop>
            <Fab color="secondary" size="small" aria-label="scroll back to top">

                <KeyboardArrowUp />
            </Fab>
        </ScrollTop>
    </div>
  );
}

export default App;
