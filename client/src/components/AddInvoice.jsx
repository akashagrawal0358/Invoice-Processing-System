
import { useState } from "react";
import { TextField, Typography, Box, Button, styled } from "@mui/material";
import { saveInvoice } from "../services/Api";

const Component = styled(Box)({
    marginTop: 20,
    '& > p': {
        fontSize: 26,
        marginBottom: 10
    },
    '& > div > div': {
        marginRight: 20,
        minWidth: 200
    }
})
 
const defaultObj = {
    vendor: '',
    product: '',
    amount: 0,
    date: '',
    action: 'pending'
}

const AddInvoice = ({ setAddInvoice }) => {
    const [invoice, setInvoice] = useState(defaultObj);
    
    // This will update all the values of defaultObj
    const onValueChange = (e) => {
        setInvoice({ ...invoice, [e.target.name]: e.target.value })
    }

    const addNewInvoice = async () => {
        // Keep all data same and typecast amount from string to number
        await saveInvoice({ ...invoice, amount: Number(invoice['amount']) });
        
        // Remove previous invoice entry
        setAddInvoice(false);
    }

    return (
        <Component>
            <Typography>Add Invoice</Typography>
            <Box>
                <TextField 
                    name="vendor"
                    variant="standard"
                    placeholder="Enter vendor name"
                    onChange={(e) => onValueChange(e)}
                    autoComplete="off"
                />
                <TextField 
                    name="product"
                    variant="standard"
                    placeholder="Enter product name"
                    onChange={(e) => onValueChange(e)}
                    autoComplete="off"
                />
                <TextField 
                    name="amount"
                    variant="standard"
                    placeholder="Enter amount (in Rs)"
                    onChange={(e) => onValueChange(e)}
                    type="number"
                    autoComplete="off"
                />
                <TextField 
                    name="date"
                    variant="standard"
                    placeholder="Enter date"
                    onChange={(e) => onValueChange(e)}
                    type="date"
                    autoComplete="off"
                />
                <Button
                    variant="contained"
                    onClick={() => addNewInvoice() }
                >Add Invoice</Button>
            </Box>
        </Component>
    )
}

export default AddInvoice;
