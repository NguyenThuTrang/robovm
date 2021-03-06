/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.audiotoolbox;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.opengles.*;
import org.robovm.apple.audiounit.*;
import org.robovm.apple.coreaudio.*;
import org.robovm.apple.coremedia.*;
import org.robovm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AudioQueueBuffer/*</name>*/ 
    extends /*<extends>*/Struct<AudioQueueBuffer>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AudioQueueBufferPtr extends Ptr<AudioQueueBuffer, AudioQueueBufferPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AudioQueueBuffer() {}
    
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    public AudioQueueBuffer setAudioData(byte[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(short[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(char[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(int[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(long[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(float[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(double[] data) {
        setArrayAudioData(data, data.length);
        return this;
    }
    public AudioQueueBuffer setAudioData(Buffer data) {
        setAudioDataByteSize(data.capacity());
        setData0(BufferMarshalers.BufferMarshaler.toNative(data, 0));
        return this;
    }
    private AudioQueueBuffer setArrayAudioData(Object array, int length) {
        setAudioDataByteSize(length);
        setData0(VM.getArrayValuesAddress(array));
        return this;
    }
    
    @SuppressWarnings("unchecked")
    public <T extends Buffer> T getAudioDataAsBuffer(Class<T> bufferType) {
        VoidPtr ptr = getDataPointer();
        if (bufferType == ByteBuffer.class) {
            return (T) ptr.as(BytePtr.class).asByteBuffer(getAudioDataByteSize());
        } else if (bufferType == CharBuffer.class) {
            return (T) ptr.as(CharPtr.class).asCharBuffer(getAudioDataByteSize());
        } else if (bufferType == ShortBuffer.class) {
            return (T) ptr.as(ShortPtr.class).asShortBuffer(getAudioDataByteSize());
        } else if (bufferType == IntBuffer.class) {
            return (T) ptr.as(IntPtr.class).asIntBuffer(getAudioDataByteSize());
        } else if (bufferType == LongBuffer.class) {
            return (T) ptr.as(LongPtr.class).asLongBuffer(getAudioDataByteSize());
        } else if (bufferType == FloatBuffer.class) {
            return (T) ptr.as(FloatPtr.class).asFloatBuffer(getAudioDataByteSize());
        } else if (bufferType == DoubleBuffer.class) {
            return (T) ptr.as(DoublePtr.class).asDoubleBuffer(getAudioDataByteSize());
        } else {
            throw new UnsupportedOperationException("Buffer type not supported: " + bufferType);
        }
    }

    public byte[] getAudioDataAsByteArray() {
        BytePtr ptr = getDataPointer().as(BytePtr.class);
        return ptr.toByteArray(getAudioDataByteSize());
    }
    public short[] getAudioDataAsShortArray() {
        ShortPtr ptr = getDataPointer().as(ShortPtr.class);
        return ptr.toShortArray(getAudioDataByteSize());
    }
    public char[] getAudioDataAsCharArray() {
        CharPtr ptr = getDataPointer().as(CharPtr.class);
        return ptr.toCharArray(getAudioDataByteSize());
    }
    public int[] getAudioDataAsIntArray() {
        IntPtr ptr = getDataPointer().as(IntPtr.class);
        return ptr.toIntArray(getAudioDataByteSize());
    }
    public long[] getAudioDataAsLongArray() {
        LongPtr ptr = getDataPointer().as(LongPtr.class);
        return ptr.toLongArray(getAudioDataByteSize());
    }
    public float[] getAudioDataAsFloatArray() {
        FloatPtr ptr = getDataPointer().as(FloatPtr.class);
        return ptr.toFloatArray(getAudioDataByteSize());
    }
    public double[] getAudioDataAsDoubleArray() {
        DoublePtr ptr = getDataPointer().as(DoublePtr.class);
        return ptr.toDoubleArray(getAudioDataByteSize());
    }
    
    public int getPacketDescriptionCount() {
        return getPacketDescriptionCount0();
    }
    public AudioStreamPacketDescription getPacketDescription(int index) {
        if (index >= getPacketDescriptionCount0()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getPacketDescriptions0().next(index).get();
    }
    public AudioQueueBuffer setPacketDescription(int index, AudioStreamPacketDescription value) {
        if (index >= getPacketDescriptionCount0()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        getPacketDescriptions0().next(index).set(value);
        return this;
    }
    public AudioStreamPacketDescription[] getPacketDescriptions() {
        int count = getPacketDescriptionCount0();
        AudioStreamPacketDescription[] array = new AudioStreamPacketDescription[count];
        AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr ptr = getPacketDescriptions0();
        for (int i = 0; i < count; i++) {
            array[i] = ptr.next(i).get();
        }
        return array;
    }
    public AudioQueueBuffer setPacketDescriptions(AudioStreamPacketDescription[] regions) {
        this.setPacketDescriptionCount0(regions.length);
        getPacketDescriptions0().set(regions);
        return this;
    }
    /*<members>*/
    @StructMember(2) protected native int getAudioDataByteSize();
    @StructMember(2) protected native AudioQueueBuffer setAudioDataByteSize(int audioDataByteSize);
    @StructMember(3) protected native VoidPtr getUserData();
    @StructMember(3) protected native AudioQueueBuffer setUserData(VoidPtr userData);
    @StructMember(5) protected native AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr getPacketDescriptions0();
    @StructMember(5) protected native AudioQueueBuffer setPacketDescriptions0(AudioStreamPacketDescription.AudioStreamPacketDescriptionPtr packetDescriptions0);
    @StructMember(6) protected native int getPacketDescriptionCount0();
    @StructMember(6) protected native AudioQueueBuffer setPacketDescriptionCount0(int packetDescriptionCount0);
    /*</members>*/
    @StructMember(0) public native int getAudioDataBytesCapacity();
    @StructMember(4) public native int getPacketDescriptionCapacity();

    @StructMember(1) protected native VoidPtr getDataPointer();
    @StructMember(1) protected native AudioQueueBuffer setData0(@Pointer long audioData);
    /*<methods>*//*</methods>*/
}
