import { useRef, useState } from "react"


export default function HomePage() {

    let [email, setEmail] = useState('')
    let [password, setPassword] = useState('')

    let emailRef = useRef()
    let passwordRef = useRef()

    function emailChangeHandler(event) {
        setEmail(event.target.value)
    }

    function passwordChangeHandler(event) {
        setPassword(event.target.value)
    }

    function submitHanlder(event) {
        event.preventDefault()
        console.log(emailRef.current.value)
        console.log(passwordRef.current.value)

        setEmail('')
        setPassword('')
    }

    return (
        <>
            <form onSubmit={submitHanlder}>
                <label>Email:</label>
                <input
                    ref={emailRef}
                    type="email"
                    id="email"
                    placeholder=""
                    value={email.value}
                    onChange={emailChangeHandler} />
                <label>Password:</label>
                <input 
                    ref={passwordRef}
                    type="password"
                    id="passowrd" 
                    placeholder=""
                    value={password.value}
                    onChange={passwordChangeHandler} />
                <button type="submit">Register</button>
            </form>
        </>
    )
}