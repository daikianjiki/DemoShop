import { useState } from "react"


export default function HomePage() {

    let [email, setEmail] = useState('')
    let [password, setPassword] = useState('')

    function emailChangeHandler() {
        setEmail()
    }

    function passwordChangeHandler() {
        setPassword()
    }

    function submitHanlder() {
        
    }

    return (
        <>
            <form onSubmit={submitHanlder}>
                <input
                    type="email"
                    id="email"
                    onChange={emailChangeHandler} >
                        Email:
                </input>
                <input 
                    type="password"
                    id="passowrd" 
                    onChange={passwordChangeHandler} >
                        Password:
                </input>
                <button type="submit">Register</button>
            </form>
        </>
    )
}