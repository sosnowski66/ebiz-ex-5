import { Product } from "../types";
import axios from "../config/AxiosConfig";

export const fetchProducts = async (): Promise<Product[]> => {
	return await axios.get("/products")
}
