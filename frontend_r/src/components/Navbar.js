import HomePage from "../pages/HomePage";
import { Link, Routes, Route } from 'react-router-dom'


export default function Navbar() {
    return (
        <div>
            <Link to="/">
                <p>Home</p>
            </Link>
            <Link to="/products">
                <p>Products</p>
            </Link>

            <Routes>
                <Route path="/" element={<HomePage/>} />
                <Route path="/products" element={<HomePage/>} />
            </Routes>
        </div>
    )
}