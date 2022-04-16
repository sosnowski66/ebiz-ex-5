import React from "react";
import { AppBar, Slide, Toolbar, Typography, useScrollTrigger } from "@mui/material";


interface HideOnScroll {
	window?: () => Window,
	children: React.ReactElement
}

const HideOnScroll: React.FC<HideOnScroll> = ({window, children}) => {
	const trigger = useScrollTrigger({
		target: window ? window() : undefined
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
			<AppBar>
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
