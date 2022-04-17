import React from "react";
import { AppBar, Slide, Toolbar, Typography, useScrollTrigger } from "@mui/material";


interface HideOnScrollProps {
	children: React.ReactElement
}

const HideOnScroll: React.FC<HideOnScrollProps> = ({children}) => {
	const trigger = useScrollTrigger({
		target: window
	})

	return (
		<Slide appear={false} direction="down" in={!trigger}>
			{children}
		</Slide>
	)
}


const Navbar: React.FC = () => (
	<div>
		<HideOnScroll>
			<AppBar elevation={0}>
				<Toolbar>
					<Typography variant="h6" component="div">
						Sklep
					</Typography>
				</Toolbar>
			</AppBar>
		</HideOnScroll>
		<Toolbar id="back-to-top-anchor"/>
	</div>
)

export default Navbar;
