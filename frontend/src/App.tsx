import React from 'react';
import { Box, Container, Fab, Typography } from "@mui/material";
import Navbar from "./components/Navbar/Navbar";
import ScrollTop from "./components/ScrollToTop/ScrollTop";
import { KeyboardArrowUp } from "@mui/icons-material";
import Products from "./components/Products/Products";
import Basket from "./components/Basket";
import { ShopContextProvider } from "./context/ShopContext";



function App() {
  return (
    <ShopContextProvider>
        <>
            <Navbar/>
            <Container>
                <Products/>
                <Typography variant="h6">KOSZYK </Typography>
                <Basket/>
                <Typography variant="h6">KOSZYK </Typography>
            </Container>
            <ScrollTop>
                <Fab color="secondary" size="small" aria-label="scroll back to top">
                    <KeyboardArrowUp />
                </Fab>
            </ScrollTop>
        </>
    </ShopContextProvider>

  );
}

export default App;
